package waffles.utils.phys.swarms.isolator;

import waffles.utils.geom.bounds.Bounds;
import waffles.utils.geom.collidable.Geometry;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.drones.linear.LinearDetectable;
import waffles.utils.phys.swarms.PairedSwarm;
import waffles.utils.phys.swarms.bounds.BoundedForce;
import waffles.utils.phys.swarms.limits.LinearDrag;

/**
 * A {@code LinearIsolator} swarm separates drones in a manifold from eachother using classical kinematics.
 * Each drone receives acceleration forces through a combination of three strategies.
 * <ul>
 * <li> {@code LinearDrag} makes drones come to a halt whenever they don't collide with anything.</li>
 * <li> {@code BoundedForce} forces drones to remain inside the bounds of the manifold.</li>
 * <li> {@code LinearIsolation} forces drones to separate from eachother. </li>
 * </ul>
 * 
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see LinearDetectable
 * @see PairedSwarm
 */
public class LinearIsolator<D extends LinearDetectable> extends PairedSwarm<D>
{
	/**
	 * A {@code LinearIsolator.Strategy} combines multiple strategies into a basic isolation algorithm.
	 * Various forces are added to drones, which are designed to separate them into a manifold space.
	 * <ul>
	 * <li> {@code LinearDrag} is implemented which makes drones come to a halt when they don't collide with anything.</li>
	 * <li> {@code BoundedForce} is implemented which adds a force whenever a drone goes out of bounds.</li>
	 * <li> {@code LinearIsolation} is implemented which adds a force whenever drones collide with eachother. </li>
	 * </ul>
	 *
	 * @author Waffles
	 * @since 08 Sep 2024
	 * @version 1.0
	 * 
	 * 
	 * @see LinearDrag
	 * @see BoundedForce
	 * @see LinearIsolation
	 */
	public class Strategy implements BoundedForce<D>, LinearDrag<D>, LinearIsolation<D>
	{		
		@Override
		public void onPulse(D src, long time)
		{
			   BoundedForce.super.onPulse(src, time);
			LinearIsolation.super.onPulse(src, time);
				 LinearDrag.super.onPulse(src, time);
		}
	
		
		@Override
		public Geometry Bounds(int dim)
		{
			Bounds bnd = Manifold().Bounds();
			switch(bound)
			{
			case BALL:
				return bnd.Ball();
			case BOX:
				return bnd.Box();
			default:
				return null;
			}
		}		
		
		@Override
		public float IsolationScale()
		{
			return iMult;
		}
		
		@Override
		public float BoundedScale()
		{
			return bMult;
		}

		@Override
		public float DragScale()
		{
			return dMult;
		}
	}
	
	
	private float bMult;
	private float dMult;
	private float iMult;
	
	private Bounds.Type bound;
	private Manifold<D> manifold;
	
	/**
	 * Creates a new {@code LinearIsolator}.
	 * 
	 * @param mfd  a drone manifold
	 * 
	 * 
	 * @see Manifold
	 */
	public LinearIsolator(Manifold<D> mfd)
	{
		bound = Bounds.Type.BOX;
		manifold = mfd;
		
		bMult = 1f;
		dMult = 1f;
		iMult = 1f;
	}
	
	
	/**
	 * Changes the bounds of the isolator.
	 * 
	 * @param bnd  a bounds type
	 * 
	 * 
	 * @see Bounds
	 */
	public void setBounds(Bounds.Type bnd)
	{
		bound = bnd;
	}
	
	/**
	 * Changes the scale of the bounded force.
	 * 
	 * @param fMult  a force multiplier
	 */
	public void setBoundedScale(float fMult)
	{
		bMult = fMult;
	}
	
	/**
	 * Changes the scale of the isolation force.
	 * 
	 * @param fMult  a force multiplier
	 */
	public void setIsolationScale(float fMult)
	{
		iMult = fMult;
	}	
		
	/**
	 * Changes the scale of the drag force.
	 * 
	 * @param fMult  a force multiplier
	 */
	public void setDragScale(float fMult)
	{
		dMult = fMult;
	}
		
	
	@Override
	public Manifold<D> Manifold()
	{
		return manifold;
	}

	@Override
	public Strategy Strategy()
	{
		return new Strategy();
	}
}