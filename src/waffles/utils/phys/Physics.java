package waffles.utils.phys;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collidable;
import waffles.utils.geom.Collision.Response;
import waffles.utils.geom.collidable.axial.cuboid.HyperCuboid;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.integrators.Integrator;
import waffles.utils.phys.utilities.events.SynchroEvent;
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
 * @see SynchroEvent
 * @see Collidable
 * @see Integrator
 */
public class Physics<O extends Collidable> implements Integrator<O>, SynchroEvent
{
	private Queue<O> queue;
	private Manifold<O> src;
	private Integrator<O> itg;
	
	/**
	 * Creates a new {@code Physics}.
	 * 
	 * @param i  a physics integrator
	 * @param s  a manifold space
	 * 
	 * 
	 * @see Integrator
	 * @see Manifold
	 */
	public Physics(Integrator<O> i, Manifold<O> s)
	{
		queue = new JFIFOQueue<>();
		itg = i; src = s;
	}
	
	/**
	 * Returns the space of the {@code Physics}.
	 * 
	 * @return  a manifold space
	 * 
	 * 
	 * @see Manifold
	 */
	public Manifold<O> Space()
	{
		return src;
	}
	
	
	@Override
	public float elasticity(O src, O tgt)
	{
		return itg.elasticity(src, tgt);
	}
	
	@Override
	public void bounce(O src, O tgt, Vector p, float c)
	{
		itg.bounce(src, tgt, p, c);
	}

	@Override
	public void bounce(O src, Vector p, float c)
	{
		itg.bounce(src, p, c);
	}	
	
	@Override
	public void update(O src, long time)
	{
		itg.update(src, time);
	}
	
	@Override
	public void onUpdate(long time)
	{
		HyperCuboid bnd = src.Bounds().Box();
		
		// For each object in the space...
		for(O obj : src)
		{
			// ...queue the object.
			queue.push(obj);
			
			// If it is outside the boundary...
			Response rsp = bnd.contain(obj);
			if(!rsp.hasImpact())
			{
				// ...generate a static impulse.
				float el = elasticity(obj, null);
				Vector dst = rsp.Distance();
				bounce(obj, dst, el);
			}
		}
		
		// For each potential collision pair...
		for(Pair<O, O> p : src.Pairs())
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

		
		src.clear();
		// Update the target space.
		for(O obj : queue)
		{
			update(obj, time);
			src.add(obj);
		}
		queue.clear();
	}
}