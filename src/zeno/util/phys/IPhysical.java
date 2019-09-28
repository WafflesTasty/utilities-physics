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
	 * Changes the rotate speed vector of the {@code IPhysical}.
	 * 
	 * @param v  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void linearSpeedTo(Vector v)
	{
		Dynamics().setLinSpeed(v);
	}
	
	/**
	 * Changes the rotate speed vector of the {@code IPhysical}.
	 * 
	 * @param v  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void rotateSpeedTo(Vector v)
	{
		Dynamics().setRotSpeed(v);
	}
	
	
	/**
	 * Adds a linear speed vector to the {@code IPhysical}.
	 * 
	 * @param v  a linear velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void linearSpeedFor(Vector v)
	{
		linearSpeedTo(LinSpeed().plus(v));
	}
	
	/**
	 * Adds a rotate speed vector to the {@code IPhysical}.
	 * 
	 * @param v  a rotate velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void rotateSpeedFor(Vector v)
	{
		rotateSpeedTo(RotSpeed().plus(v));
	}
	
	
	/**
	 * Returns the linear speed of the {@code IPhysical}.
	 * 
	 * @return  a linear speed vector
	 * 
	 * 
	 * @see Vector
	 */
	public default Vector LinSpeed()
	{
		return Dynamics().LinSpeed();
	}
	
	/**
	 * Returns the rotate speed of the {@code IPhysical}.
	 * 
	 * @return  a rotate speed vector
	 * 
	 * 
	 * @see Vector
	 */
	public default Vector RotSpeed()
	{
		return Dynamics().RotSpeed();
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