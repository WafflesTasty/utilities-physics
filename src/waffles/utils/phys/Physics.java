package waffles.utils.phys;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collidable;
import waffles.utils.geom.Collision.Response;
import waffles.utils.geom.bounds.Bounds;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.integrators.Integrator;
import waffles.utils.phys.integrators.fixed.Delegator;
import waffles.utils.phys.utilities.events.PulseEvent;
import waffles.utils.phys.utilities.events.SteppedEvent;
import waffles.utils.sets.keymaps.Pair;
import waffles.utils.sets.queues.Queue;
import waffles.utils.sets.queues.delegate.JFIFOQueue;

/**
 * A {@code Physics} object handles synchronized physics in a {@code Manifold}.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see SteppedEvent
 * @see Collidable
 * @see Delegator
 */
public class Physics<O extends Collidable> extends SteppedEvent implements Delegator<O>
{
	/**
	 * A {@code Pulse} defines the main {@code PulseEvent} of a {@code Physics} event.
	 *
	 * @author Waffles
	 * @since 20 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see PulseEvent
	 */
	public class Pulse extends PulseEvent
	{
		private Queue<O> queue;

		/**
		 * Creates a new {@code Pulse}.
		 * 
		 * @param beat  a beat time
		 */
		public Pulse(long beat)
		{
			super(beat);
			queue = new JFIFOQueue<>();
		}

		
		@Override
		public void onPulse(long beat)
		{
			Bounds bnd = Manifold().Bounds();
			// For each object in the space...
			for(O obj : Manifold())
			{
				// ...queue the object.
				queue.push(obj);
				
				// If it is outside the boundary...
				Response rsp = bnd.Box().contain(obj);
				if(!rsp.hasImpact())
				{
					// ...generate a static impulse.
					float el = elasticity(obj, null);
					Vector dst = rsp.Distance();
					bounce(obj, dst, el);
				}
			}
			

			// For each potential collision pair...
			for(Pair<O, O> p : Manifold().Pairs())
			{
				O o1 = p.Key();
				O o2 = p.Value();
	
				// If collision occurs between them...
				Response rsp = o1.intersect(o2);
				if(rsp.hasImpact())
				{	
					// ...generate a dynamic impulse.
					float el = elasticity(o1, o2);
					Vector pnt = rsp.Penetration();
					bounce(o1, o2, pnt, el);
				}
			}
	
			
			Manifold().clear();
			// Update the target space.
			for(O obj : queue)
			{
				update(obj, beat);
				Manifold().add(obj);
			}

			queue.clear();
		}
		
	}
	
	
	private Pulse pulse;
	private Manifold<O> src;
	private Integrator<O> itg;
	
	/**
	 * Creates a new {@code Physics}.
	 * 
	 * @param i  a physics integrator
	 * @param s  a manifold space
	 * @param b  a beat size
	 * 
	 * 
	 * @see Integrator
	 * @see Manifold
	 */
	public Physics(Integrator<O> i, Manifold<O> s, int b)
	{
		itg = i; src = s;
		
		pulse = new Pulse(b);
	}
	
	/**
	 * Creates a new {@code Physics}.
	 * 
	 * @param s  a manifold space
	 * @param b  a beat size
	 * 
	 * 
	 * @see Integrator
	 * @see Manifold
	 */
	public Physics(Manifold<O> s, int b)
	{
		this(null, s, b);
	}
	
	/**
	 * Creates a new {@code Physics}.
	 * 
	 * @param b  a beat size
	 * 
	 * 
	 * @see Integrator
	 * @see Manifold
	 */
	public Physics(int b)
	{
		this(null, b);
	}

	
	/**
	 * Returns the physics {@code Manifold}.
	 * 
	 * @return  a manifold space
	 * 
	 * 
	 * @see Manifold
	 */
	public Manifold<O> Manifold()
	{
		return src;
	}
	
	/**
	 * Changes the physics {@code Manifold}.
	 * 
	 * @param s  a manifold source
	 * 
	 * 
	 * @see Manifold
	 */
	public void setManifold(Manifold<O> s)
	{
		src = s;
	}
	
	/**
	 * Changes the physics {@code Integrator}.
	 * 
	 * @param i  a time integrator
	 * 
	 * 
	 * @see Integrator
	 */
	public void setIntegrator(Integrator<O> i)
	{
		itg = i;
	}
	
	
	@Override
	public Integrator<O> Integrator()
	{
		return itg;
	}
	
	@Override
	public void onStep()
	{
		long beat = pulse.Beat();
		pulse.onPulse(beat);
	}
}