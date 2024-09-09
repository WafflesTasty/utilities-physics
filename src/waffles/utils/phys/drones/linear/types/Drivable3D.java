package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.geom.spatial.types.Movable3D;

/**
 * A {@code Drivable3D} can maintain its own linear speed in three-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Movable3D
 * @see Drivable
 */
public interface Drivable3D extends Drivable, Movable3D
{
	@Override
	public default Vector3 LinSpeed()
	{
		return (Vector3) Drivable.super.LinSpeed();
	}

	
	/**
	 * Speeds the {@code Drivable3D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void speedFor(float x, float y, float z)
	{
		speedFor(new Vector3(x, y, z));
	}
	
	/**
	 * Speeds the {@code Drivable3D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 * @param z  a linear speed z
	 */
	public default void speedTo(float x, float y, float z)
	{
		speedTo(new Vector3(x, y, z));
	}
}