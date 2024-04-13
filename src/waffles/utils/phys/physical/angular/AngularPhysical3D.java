package waffles.utils.phys.physical.angular;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
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
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 * @param z  an angular velocity z-coordinate
	 */
	public default void addRotSpeed(float x, float y, float z)
	{
		addRotSpeed(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the angular speed of the {@code AffinePhysical3D}.
	 * 
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 * @param z  an angular velocity z-coordinate
	 */
	public default void setRotSpeed(float x, float y, float z)
	{
		setRotSpeed(new Vector3(x, y, z));
	}
	

	@Override
	public default Vector3 RotSpeed()
	{
		return (Vector3) AngularPhysical.super.RotSpeed();
	}
}