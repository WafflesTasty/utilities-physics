package zeno.util.phys.entities;

import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.geom.collidables.IShapeable2D;
import zeno.util.geom.utilities.spin.Spin2D;
import zeno.util.phys.IPhysical;

/**
 * The {@code IPhysical2D} interface defines a two-dimensional object with Newtonian physics properties.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see IShapeable2D
 * @see IPhysical
 */
public interface IPhysical2D extends IPhysical, IShapeable2D
{
	/**
	 * Adds a rotate speed to the {@code IPhysical2D}.
	 * 
	 * @param a  a spin velocity angle
	 */
	public default void addRotSpeed(float a)
	{
		addRotSpeed(new Spin2D(a));
	}
	
	/**
	 * Adds a linear speed to the {@code IPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void addLinSpeed(float x, float y)
	{
		addLinSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the linear speed of the {@code IPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void setLinSpeed(float x, float y)
	{
		setLinSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the rotate speed of the {@code IPhysical2D}.
	 * 
	 * @param a  a spin velocity angle
	 */
	public default void setRotSpeed(float a)
	{
		setRotSpeed(new Spin2D(a));
	}
	
	
	@Override
	public abstract Dynamics2D Dynamics();
	
	
	@Override
	public default Vector2 LinSpeed()
	{
		return (Vector2) IPhysical.super.LinSpeed();
	}
	
	@Override
	public default Spin2D RotSpeed()
	{
		return (Spin2D) IPhysical.super.RotSpeed();
	}
}