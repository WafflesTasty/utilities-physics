package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.complex.Quaternion;
import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.data.spin.Spin3D;
import waffles.utils.geom.spatial.types.Rotatable3D;

/**
 * A {@code Screwable3D} can maintain its own angular speed in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Rotatable3D
 * @see Screwable
 */
public interface Screwable3D extends Screwable, Rotatable3D
{
	@Override
	public default Spin3D AngSpeed()
	{
		return (Spin3D) Screwable.super.AngSpeed();
	}

	
	/**
	 * Screws the {@code Screwable3D} for an angular spin.
	 * 
	 * @param q  a rotation versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void screwFor(Quaternion q)
	{
		screwFor(new Spin3D(q));
	}
	
	/**
	 * Screws the {@code Screwable3D} for an angular spin.
	 * 
	 * @param v  an angular vector
	 * @param a  an angular speed
	 * 
	 * 
	 * @see Vector3
	 */
	public default void screwFor(Vector3 v, float a)
	{
		screwFor(new Spin3D(v, a));
	}
	
	/**
	 * Screws the {@code Screwable3D} to an angular spin.
	 * 
	 * @param v  an angular vector
	 * @param a  an angular speed
	 * 
	 * 
	 * @see Vector3
	 */
	public default void screwTo(Vector3 v, float a)
	{
		screwTo(new Spin3D(v, a));
	}
	
	/**
	 * Screws the {@code Screwable3D} to an angular spin.
	 * 
	 * @param q  a rotation versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void screwTo(Quaternion q)
	{
		screwTo(new Spin3D(q));
	}
}