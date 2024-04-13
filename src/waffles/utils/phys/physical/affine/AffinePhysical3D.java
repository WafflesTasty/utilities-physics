package waffles.utils.phys.physical.affine;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.collidable.geometric.AffineOriented3D;
import waffles.utils.phys.physical.aligned.AlignedPhysical3D;

/**
 * An {@code AffinePhysical3D} defines a three-dimensional affine-oriented object with general Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AlignedPhysical3D
 * @see AffineOriented3D
 * @see AffinePhysical
 */
public interface AffinePhysical3D extends AffinePhysical, AlignedPhysical3D, AffineOriented3D
{
	/**
	 * Adds an angular impulse to the {@code AffinePhysical3D}.
	 * 
	 * @param x  an angular impulse x-coordinate
	 * @param y  an angular impulse y-coordinate
	 * @param z  an angular impulse z-coordinate
	 */
	public default void addRotImpulse(float x, float y, float z)
	{
		addRotImpulse(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the angular impulse of the {@code AffinePhysical3D}.
	 * 
	 * @param x  an angular impulse x-coordinate
	 * @param y  an angular impulse y-coordinate
	 * @param z  an angular impulse z-coordinate
	 */
	public default void setRotImpulse(float x, float y, float z)
	{
		setRotImpulse(new Vector3(x, y, z));
	}
	
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
	public default Vector3 RotImpulse()
	{
		return (Vector3) AffinePhysical.super.RotImpulse();
	}

	@Override
	public default Vector3 RotSpeed()
	{
		return (Vector3) AffinePhysical.super.RotSpeed();
	}
}