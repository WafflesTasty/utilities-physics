package waffles.utils.phys.physical.angular;

import waffles.utils.algebra.elements.complex.Quaternion;
import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.data.spin.Spin3D;
import waffles.utils.geom.spatial.types.Rotatable3D;

/**
 * An {@code AngularPhysical3D} defines a three-dimensional rotatable object with angular Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AngularPhysical
 * @see Rotatable3D
 */
public interface AngularPhysical3D extends AngularPhysical, Rotatable3D
{
	/**
	 * Adds an angular speed to the {@code AffinePhysical3D}.
	 * 
	 * @param q  a rotation quaternion
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void addRotSpeed(Quaternion q)
	{
		addRotSpeed(new Spin3D(q));
	}
	
	/**
	 * Adds an angular speed to the {@code AffinePhysical3D}.
	 * 
	 * @param v  a rotation vector
	 * @param a  a rotation angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void addRotSpeed(Vector3 v, float a)
	{
		addRotSpeed(new Spin3D(v, a));
	}
	
	/**
	 * Changes the angular speed of the {@code AffinePhysical3D}.
	 * 
	 * @param v  a rotation vector
	 * @param a  a rotation angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void setRotSpeed(Vector3 v, float a)
	{
		setRotSpeed(new Spin3D(v, a));
	}
	
	/**
	 * Changes the angular speed of the {@code AffinePhysical3D}.
	 * 
	 * @param q  a rotation quaternion
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void setRotSpeed(Quaternion q)
	{
		setRotSpeed(new Spin3D(q));
	}
	

	@Override
	public default Spin3D RotSpeed()
	{
		return (Spin3D) AngularPhysical.super.RotSpeed();
	}
}