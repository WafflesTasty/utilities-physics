package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

/**
 * A {@code Pressable2D} can maintain its own scalar force in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Pressable
 * @see Wedgable2D
 */
public interface Pressable2D extends Pressable, Wedgable2D
{
	@Override
	public default Vector2 PinForce()
	{
		return (Vector2) Pressable.super.PinForce();
	}

	
	/**
	 * Squeezes the {@code Pressable2D} for a scalar vector.
	 * 
	 * @param x  a scalar force x
	 * @param y  a scalar force y
	 */
	public default void squeezeFor(float x, float y)
	{
		squeezeFor(new Vector2(x, y));
	}
	
	/**
	 * Squeezes the {@code Pressable2D} to a scalar vector.
	 * 
	 * @param x  a scalar force x
	 * @param y  a scalar force y
	 */
	public default void squeezeTo(float x, float y)
	{
		squeezeTo(new Vector2(x, y));
	}
}