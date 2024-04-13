package waffles.utils.phys;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collision.Response;
import waffles.utils.geom.collidable.axial.cuboid.HyperCuboid;
import waffles.utils.geom.spaces.Manifold;
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
 * @see Physical
 */
public abstract class Physics<O extends Physical> implements SynchroEvent
{
	private Queue<O> queue;
	private Manifold<O> src;
	
	/**
	 * Creates a new {@code Physics}.
	 * 
	 * @param s  a manifold space
	 * 
	 * 
	 * @see Manifold
	 */
	public Physics(Manifold<O> s)
	{
		queue = new JFIFOQueue<>();
		src = s;
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
	
	
	/**
	 * Bounces two objects off eachother in the {@code Physics}.
	 * 
	 * @param src  a source object
	 * @param tgt  a target object
	 * @param p    a penetration vector
	 * @param c    an elasticity value
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void bounce(O src, O tgt, Vector p, float c);
	
	/**
	 * Bounces an object off an immovable in the {@code Physics}.
	 * 
	 * @param src  a source object
	 * @param p    a penetration vector
	 * @param c    an elasticity value
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void bounce(O src, Vector p, float c);
	
	
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
				Vector dst = rsp.Distance();
				bounce(obj, dst, 1f);
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
				Vector pnt = rsp.Penetration();
				bounce(o1, o2, pnt, 1f);
			}
		}

		
		src.clear();
		// Update the target space.
		for(O obj : queue)
		{
			obj.onUpdate(time);			
			src.add(obj);
		}
		queue.clear();
	}
}