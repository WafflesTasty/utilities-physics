package waffles.utils.phys.physical.aligned;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.collidable.geometric.AxisAligned3D;

/**
 * An {@code AlignedPhysical3D} defines a three-dimensional axis-aligned object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AlignedPhysical
 * @see AxisAligned3D
 */
public interface AlignedPhysical3D extends AlignedPhysical, AxisAligned3D
{
	/**
	 * Adds a linear impulse to the {@code AlignedPhysical3D}.
	 * 
	 * @param x  a linear impulse x-coordinate
	 * @param y  a linear impulse y-coordinate
	 * @param z  a linear impulse z-coordinate
	 */
	public default void addLinImpulse(float x, float y, float z)
	{
		addLinImpulse(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the linear impulse of the {@code AlignedPhysical3D}.
	 * 
	 * @param x  a linear impulse x-coordinate
	 * @param y  a linear impulse y-coordinate
	 * @param z  a linear impulse z-coordinate
	 */
	public default void setLinImpulse(float x, float y, float z)
	{
		setLinImpulse(new Vector3(x, y, z));
	}
	
	/**
	 * Adds a linear speed to the {@code AlignedPhysical3D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 * @param z  a linear velocity z-coordinate
	 */
	public default void addLinSpeed(float x, float y, float z)
	{
		addLinSpeed(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the linear speed of the {@code AlignedPhysical3D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 * @param z  a linear velocity z-coordinate
	 */
	public default void setLinSpeed(float x, float y, float z)
	{
		setLinSpeed(new Vector3(x, y, z));
	}

	
	@Override
	public default Vector3 LinImpulse()
	{
		return (Vector3) AlignedPhysical.super.LinImpulse();
	}

	@Override
	public default Vector3 LinSpeed()
	{
		return (Vector3) AlignedPhysical.super.LinSpeed();
	}
}