package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;

/**
 * A {@code Pressable3D} can maintain its own scalar force in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Pressable
 * @see Wedgable3D
 */
public interface Pressable3D extends Pressable, Wedgable3D
{
	@Override
	public default Vector3 PinForce()
	{
		return (Vector3) Pressable.super.PinForce();
	}

	
	/**
	 * Squeezes the {@code Pressable3D} for a scalar vector.
	 * 
	 * @param x  a scalar force x
	 * @param y  a scalar force y
	 * @param z  a scalar force z
	 */
	public default void squeezeFor(float x, float y, float z)
	{
		squeezeFor(new Vector3(x, y, z));
	}
	
	/**
	 * Squeezes the {@code Pressable3D} to a scalar vector.
	 * 
	 * @param x  a scalar force x
	 * @param y  a scalar force y
	 * @param z  a scalar force z
	 */
	public default void squeezeTo(float x, float y, float z)
	{
		squeezeTo(new Vector3(x, y, z));
	}
}