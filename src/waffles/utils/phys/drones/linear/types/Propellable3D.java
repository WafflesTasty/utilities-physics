package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;

/**
 * A {@code Propellable3D} can maintain its own linear acceleration in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Propellable
 * @see Drivable3D
 */
public interface Propellable3D extends Propellable, Drivable3D
{
	@Override
	public default Vector3 LinAccel()
	{
		return (Vector3) Propellable.super.LinAccel();
	}

	
	/**
	 * Propels the {@code Propellable3D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void propelFor(float x, float y, float z)
	{
		propelFor(new Vector3(x, y, z));
	}
	
	/**
	 * Propels the {@code Propellable3D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void propelTo(float x, float y, float z)
	{
		propelTo(new Vector3(x, y, z));
	}
}