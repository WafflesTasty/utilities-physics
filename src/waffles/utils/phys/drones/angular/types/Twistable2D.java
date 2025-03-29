package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin2D;

/**
 * A {@code Twistable2D} can maintain its own angular acceleration in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Screwable2D
 * @see Twistable
 */
public interface Twistable2D extends Twistable, Screwable2D
{
	@Override
	public default Spin2D AngSpeed()
	{
		return Screwable2D.super.AngSpeed();
	}

	
	/**
	 * Twists the {@code Twistable2D} for an angular spin.
	 * 
	 * @param a  an angular acceleration
	 */
	public default void twistFor(float a)
	{
		twistFor(new Spin2D(a));
	}
	
	/**
	 * Twists the {@code Twistable2D} to an angular spin.
	 * 
	 * @param a  an angular acceleration
	 */
	public default void twistTo(float a)
	{
		twistTo(new Spin2D(a));
	}
}