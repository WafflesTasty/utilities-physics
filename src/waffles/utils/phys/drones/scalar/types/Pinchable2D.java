package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.spatial.types.Scalable2D;

/**
 * A {@code Pinchable2D} can maintain its own scalar speed in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Scalable2D
 * @see Pinchable
 */
public interface Pinchable2D extends Pinchable, Scalable2D
{
	@Override
	public default Vector2 PinSpeed()
	{
		return (Vector2) Pinchable.super.PinSpeed();
	}

	
	/**
	 * Pinches the {@code Drivable2D} for a scalar vector.
	 * 
	 * @param x  a scalar speed x
	 * @param y  a scalar speed y
	 */
	public default void pinchFor(float x, float y)
	{
		pinchFor(new Vector2(x, y));
	}
	
	/**
	 * Pinches the {@code Drivable2D} to a scalar vector.
	 * 
	 * @param x  a scalar speed x
	 * @param y  a scalar speed y
	 */
	public default void pinchTo(float x, float y)
	{
		pinchTo(new Vector2(x, y));
	}
}