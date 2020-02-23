package zeno.util.phys.entities;

import zeno.util.algebra.imaginary.Quaternion;
import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.IShapeable3D;
import zeno.util.geom.utilities.spin.Spin3D;
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
	 * Adds a rotate speed to the {@code IPhysical3D}.
	 * 
	 * @param v  a spin velocity versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void addRotSpeed(Quaternion v)
	{
		addRotSpeed(new Spin3D(v));
	}
	
	/**
	 * Adds a rotate speed to the {@code IPhysical3D}.
	 * 
	 * @param v  a spin velocity vector
	 * @param a  a spin velocity angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void addRotSpeed(Vector3 v, float a)
	{
		addRotSpeed(new Spin3D(v, a));
	}
	
	/**
	 * Adds a linear speed to the {@code IPhysical3D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 * @param z  a linear velocity z-coordinate
	 */
	public default void addLinSpeed(float x, float y, float z)
	{
		addLinSpeed(new Vector2(x, y));
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
	 * @param v  a spin velocity vector
	 * @param a  a spin velocity angle
	 * 
	 * 
	 * @see Vector3
	 */
	public default void setRotSpeed(Vector3 v, float a)
	{
		setRotSpeed(new Spin3D(v, a));
	}
	
	/**
	 * Changes the rotate speed of the {@code IPhysical3D}.
	 * 
	 * @param v  a spin velocity versor
	 * 
	 * 
	 * @see Quaternion
	 */
	public default void setRotSpeed(Quaternion v)
	{
		setRotSpeed(new Spin3D(v));
	}
			
	
	@Override
	public abstract Dynamics3D Dynamics();

	
	@Override
	public default Vector3 LinSpeed()
	{
		return (Vector3) IPhysical.super.LinSpeed();
	}
	
	@Override
	public default Spin3D RotSpeed()
	{
		return (Spin3D) IPhysical.super.RotSpeed();
	}
}