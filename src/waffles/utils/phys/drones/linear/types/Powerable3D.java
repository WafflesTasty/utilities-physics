package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;

/**
 * A {@code Powerable3D} can maintain its own linear force in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Propellable3D
 * @see Powerable
 */
public interface Powerable3D extends Powerable, Propellable3D
{
	@Override
	public default Vector3 LinForce()
	{
		return (Vector3) Powerable.super.LinForce();
	}

	
	/**
	 * Powers the {@code Powerable3D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void powerFor(float x, float y, float z)
	{
		powerFor(new Vector3(x, y, z));
	}
	
	/**
	 * Powers the {@code Powerable3D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void powerTo(float x, float y, float z)
	{
		powerTo(new Vector3(x, y, z));
	}
}