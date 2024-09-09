package waffles.utils.phys.swarms.bounds;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collision.Response;
import waffles.utils.geom.collidable.Geometry;
import waffles.utils.geom.collidable.fixed.Universe;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.Strategy;

/**
 * A {@code BoundedStrategy} updates drones when hitting a bounded {@code Geometry}.
 *
 * @author Waffles
 * @since 19 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see Dynamical
 * @see Strategy
 */
public interface BoundedStrategy<D extends Dynamical> extends Strategy<D>
{
	/**
	 * Returns the bounds of the {@code BoundedStrategy}.
	 * 
	 * @param dim  a space dimension
	 * @return   a geometry bounds
	 * 
	 * 
	 * @see Geometry
	 */
	public default Geometry Bounds(int dim)
	{
		return new Universe(dim);
	}
	
	/**
	 * An event raised when hitting bounds in the {@code BoundedStrategy}.
	 * 
	 * @param src   a source drone
	 * @param dst   a distance vector
	 * @param time  a time interval
	 */
	public default void onBound(D src, Vector dst, long time)
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public default void onPulse(D src, long time)
	{
		Geometry bnd = Bounds(src.Dimension());
		Response rsp = bnd.contain(src);
		if(!rsp.hasImpact())
		{
			Vector dst = rsp.Distance();
			onBound(src, dst, time);
		}
	}
}