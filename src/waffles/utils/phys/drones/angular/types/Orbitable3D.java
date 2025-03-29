package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;

/**
 * An {@code Orbitable3D} can maintain its own angular force in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Twistable3D
 * @see Orbitable
 */
public interface Orbitable3D extends Orbitable, Twistable3D
{
	@Override
	public default Vector3 AngForce()
	{
		return (Vector3) Orbitable.super.AngForce();
	}

	
	/**
	 * Orbits the {@code Orbitable3D} for an angular vector.
	 * 
	 * @param x  an angular force x
	 * @param y  an angular force y
	 * @param z  an angular force z
	 */
	public default void orbitFor(float x, float y, float z)
	{
		orbitFor(new Vector3(x, y, z));
	}
	
	/**
	 * Orbits the {@code Orbitable3D} to an angular vector.
	 * 
	 * @param x  an angular force x
	 * @param y  an angular force y
	 * @param z  an angular force z
	 */
	public default void orbitTo(float x, float y, float z)
	{
		orbitTo(new Vector3(x, y, z));
	}
}