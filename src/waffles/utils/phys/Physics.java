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
public abstract class Physics<O extends Collidable> extends SteppedEvent implements Delegator<O>
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
		pulse = new Pulse(b);
	}

	/**
	 * Returns the physics {@code Manifold}.
	 * 
	 * @return  a manifold space
	 * 
	 * 
	 * @see Manifold
	 */
	public abstract Manifold<O> Manifold();

	
	@Override
	public void onStep()
	{
		long beat = pulse.Beat();
		pulse.onPulse(beat);
	}
}