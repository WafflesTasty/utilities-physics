package zeno.util.phys.entities;

import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.IShapeable3D;
import zeno.util.phys.IPhysical;

/**
 * The {@code IPhysical3D} interface defines a three-dimensional object with Newtonian physics properties.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see IShapeable3D
 * @see IPhysical
 */
public interface IPhysical3D extends IPhysical, IShapeable3D
{
	/**
	 * Adds a linear speed to the {@code IPhysical3D}.
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
	 * Adds a rotate speed to the {@code IPhysical3D}.
	 * 
	 * @param x  a rotate velocity x-coordinate
	 * @param y  a rotate velocity y-coordinate
	 * @param z  a rotate velocity z-coordinate
	 */
	public default void addRotSpeed(float x, float y, float z)
	{
		addRotSpeed(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the linear speed of the {@code IPhysical3D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 * @param z  a linear velocity z-coordinate
	 */
	public default void setLinSpeed(float x, float y, float z)
	{
		setLinSpeed(new Vector3(x, y, z));
	}
	
	/**
	 * Changes the rotate speed of the {@code IPhysical3D}.
	 * 
	 * @param x  a rotate velocity x-coordinate
	 * @param y  a rotate velocity y-coordinate
	 * @param z  a rotate velocity z-coordinate
	 */
	public default void setRotSpeed(float x, float y, float z)
	{
		setRotSpeed(new Vector3(x, y, z));
	}

	
	@Override
	public abstract Dynamics3D Dynamics();

	
	@Override
	public default Vector3 LinSpeed()
	{
		return (Vector3) IPhysical.super.LinSpeed();
	}
	
	@Override
	public default Vector3 RotSpeed()
	{
		return (Vector3) IPhysical.super.RotSpeed();
	}
}