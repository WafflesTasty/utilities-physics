package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.types.Movable3D;

/**
 * An {@code LinearPhysical3D} defines a three-dimensional axis-aligned object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see LinearPhysical
 * @see Movable3D
 */
public interface LinearPhysical3D extends LinearPhysical, Movable3D
{
	/**
	 * Adds a linear speed to the {@code LinearPhysical3D}.
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
	 * Changes the linear speed of the {@code LinearPhysical3D}.
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
	public default Vector3 LinSpeed()
	{
		return (Vector3) LinearPhysical.super.LinSpeed();
	}
}