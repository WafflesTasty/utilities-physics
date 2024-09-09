package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.spatial.types.Movable2D;

/**
 * A {@code Drivable2D} can maintain its own linear speed in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Movable2D
 * @see Drivable
 */
public interface Drivable2D extends Drivable, Movable2D
{
	@Override
	public default Vector2 LinSpeed()
	{
		return (Vector2) Drivable.super.LinSpeed();
	}

	
	/**
	 * Speeds the {@code Drivable2D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void speedFor(float x, float y)
	{
		speedFor(new Vector2(x, y));
	}
	
	/**
	 * Speeds the {@code Drivable2D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void speedTo(float x, float y)
	{
		speedTo(new Vector2(x, y));
	}
}