package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.complex.Quaternion;
import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.data.spin.Spin3D;

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
	public default Spin3D AngForce()
	{
		return (Spin3D) Orbitable.super.AngForce();
	}

	
	/**
	 * Orbits the {@code Orbitable3D} for an angular vector.
	 * 
	 * @param q  a versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void orbitFor(Quaternion q)
	{
		orbitFor(new Spin3D(q));
	}
	
	/**
	 * Orbits the {@code Orbitable3D} for an angular vector.
	 * 
	 * @param v  a rotation vector
	 * @param a  a rotation angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void orbitFor(Vector3 v, float a)
	{
		orbitFor(new Spin3D(v, a));
	}
	
	/**
	 * Orbits the {@code Orbitable3D} to an angular vector.
	 * 
	 * @param v  a rotation vector
	 * @param a  a rotation angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void orbitTo(Vector3 v, float a)
	{
		orbitTo(new Spin3D(v, a));
	}
	
	/**
	 * Orbits the {@code Orbitable3D} to an angular vector.
	 * 
	 * @param q  a versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void orbitTo(Quaternion q)
	{
		orbitTo(new Spin3D(q));
	}
}