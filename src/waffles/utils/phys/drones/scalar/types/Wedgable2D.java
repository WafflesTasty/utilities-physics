package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

/**
 * A {@code Wedgable2D} can maintain its own scalar acceleration in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Pinchable2D
 * @see Wedgable
 */
public interface Wedgable2D extends Wedgable, Pinchable2D
{
	@Override
	public default Vector2 PinAccel()
	{
		return (Vector2) Wedgable.super.PinAccel();
	}

	
	/**
	 * Wedges the {@code Wedgable2D} for a scalar vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void wedgeFor(float x, float y)
	{
		wedgeFor(new Vector2(x, y));
	}
	
	/**
	 * Wedges the {@code Wedgable2D} to a scalar vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void wedgeTo(float x, float y)
	{
		wedgeTo(new Vector2(x, y));
	}
}