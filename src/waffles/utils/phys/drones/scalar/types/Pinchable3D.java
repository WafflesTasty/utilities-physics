package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.types.Scalable3D;

/**
 * A {@code Pinchable3D} can maintain its own scalar speed in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Scalable3D
 * @see Pinchable
 */
public interface Pinchable3D extends Pinchable, Scalable3D
{
	@Override
	public default Vector3 PinSpeed()
	{
		return (Vector3) Pinchable.super.PinSpeed();
	}

	
	/**
	 * Pinches the {@code Pinchable3D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void pinchFor(float x, float y, float z)
	{
		pinchFor(new Vector3(x, y, z));
	}
	
	/**
	 * Pinches the {@code Pinchable3D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void pinchTo(float x, float y, float z)
	{
		pinchTo(new Vector3(x, y, z));
	}
}