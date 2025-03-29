package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin2D;
import waffles.utils.geom.spatial.types.Rotatable2D;

/**
 * A {@code Screwable2D} can maintain its own angular speed in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Rotatable2D
 * @see Screwable
 */
public interface Screwable2D extends Screwable, Rotatable2D
{
	@Override
	public default Spin2D AngSpeed()
	{
		return (Spin2D) Screwable.super.AngSpeed();
	}

	
	/**
	 * Screws the {@code Screwable2D} for an angular spin.
	 * 
	 * @param a  an angular speed
	 */
	public default void screwFor(float a)
	{
		screwFor(new Spin2D(a));
	}
	
	/**
	 * Screws the {@code Screwable2D} to an angular spin.
	 * 
	 * @param a  an angular speed
	 */
	public default void screwTo(float a)
	{
		screwTo(new Spin2D(a));
	}
}