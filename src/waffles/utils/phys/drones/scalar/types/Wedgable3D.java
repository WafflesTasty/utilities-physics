package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;

/**
 * A {@code Wedgable3D} can maintain its own scalar acceleration in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Pinchable3D
 * @see Wedgable
 */
public interface Wedgable3D extends Wedgable, Pinchable3D
{
	@Override
	public default Vector3 PinAccel()
	{
		return (Vector3) Wedgable.super.PinAccel();
	}

	
	/**
	 * Wedges the {@code Wedgable3D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void wedgeFor(float x, float y, float z)
	{
		wedgeFor(new Vector3(x, y, z));
	}
	
	/**
	 * Wedges the {@code Wedgable3D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void wedgeTo(float x, float y, float z)
	{
		wedgeTo(new Vector3(x, y, z));
	}
}