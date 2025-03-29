package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.complex.Quaternion;
import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.data.spin.Spin3D;

/**
 * A {@code Twistable3D} can maintain its own angular acceleration in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Screwable3D
 * @see Twistable
 */
public interface Twistable3D extends Twistable, Screwable3D
{
	@Override
	public default Spin3D AngSpeed()
	{
		return Screwable3D.super.AngSpeed();
	}

	
	/**
	 * Twists the {@code Screwable3D} for an angular spin.
	 * 
	 * @param q  a rotation versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void twistFor(Quaternion q)
	{
		twistFor(new Spin3D(q));
	}
	
	/**
	 * Twists the {@code Screwable3D} for an angular spin.
	 * 
	 * @param v  an angular vector
	 * @param a  an angular speed
	 * 
	 * 
	 * @see Vector3
	 */
	public default void twistFor(Vector3 v, float a)
	{
		twistFor(new Spin3D(v, a));
	}
	
	/**
	 * Twists the {@code Screwable3D} to an angular spin.
	 * 
	 * @param v  an angular vector
	 * @param a  an angular speed
	 * 
	 * 
	 * @see Vector3
	 */
	public default void twistTo(Vector3 v, float a)
	{
		twistTo(new Spin3D(v, a));
	}
	
	/**
	 * Twists the {@code Screwable3D} to an angular spin.
	 * 
	 * @param q  a rotation versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void twistTo(Quaternion q)
	{
		twistTo(new Spin3D(q));
	}
}