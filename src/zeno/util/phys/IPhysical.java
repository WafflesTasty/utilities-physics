package zeno.util.phys;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.geom.collidables.IShapeable;

/**
 * The {@code IPhysical} interface defines an object with Newtonian physics properties.
 * 
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see IShapeable
 */
public interface IPhysical extends IShapeable
{	
	/**
	 * Returns the dynamics of the {@code IPhysical}.
	 * 
	 * @return  the object dynamics
	 * 
	 * 
	 * @see IDynamics
	 */
	public abstract IDynamics Dynamics();
	
	
	/**
	 * Changes the rotate speed of the {@code IPhysical}.
	 * 
	 * @param v  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void setRotSpeed(Vector v)
	{
		Dynamics().setRotSpeed(v);
	}
	
	/**
	 * Changes the linear speed of the {@code IPhysical}.
	 * 
	 * @param v  a linear velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void setLinSpeed(Vector v)
	{
		Dynamics().setLinSpeed(v);
	}
		
	/**
	 * Adds a linear speed to the {@code IPhysical}.
	 * 
	 * @param v  a linear velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void addLinSpeed(Vector v)
	{
		Dynamics().addLinSpeed(v);
	}
	
	/**
	 * Adds a rotate speed to the {@code IPhysical}.
	 * 
	 * @param v  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void addRotSpeed(Vector v)
	{
		Dynamics().addRotSpeed(v);
	}
	
	
	/**
	 * Returns the rotate speed of the {@code IPhysical}.
	 * 
	 * @return  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default Vector RotSpeed()
	{
		return Dynamics().RotSpeed();
	}
	
	/**
	 * Returns the linear speed of the {@code IPhysical}.
	 * 
	 * @return  a linear velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default Vector LinSpeed()
	{
		return Dynamics().LinSpeed();
	}
		
	/**
	 * Returns the inertia of the {@code IPhysical}.
	 * 
	 * @return  an object inertia
	 */
	public default float Inertia()
	{
		return Dynamics().Inertia();
	}
	
	/**
	 * Returns the mass of the {@code IPhysical}.
	 * 
	 * @return  an object mass
	 */
	public default float Mass()
	{
		return Dynamics().Mass();
	}
}