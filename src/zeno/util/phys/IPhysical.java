package zeno.util.phys;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.geom.collidables.IShapeable;
import zeno.util.geom.utilities.spin.Spin;

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
	 * @param s  a spin velocity
	 * 
	 * 
	 * @see Spin
	 */
	public default void setRotSpeed(Spin s)
	{
		Dynamics().setRotSpeed(s);
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
	 * @param s  a spin velocity
	 * 
	 * 
	 * @see Vector
	 */
	public default void addRotSpeed(Spin s)
	{
		Dynamics().addRotSpeed(s);
	}
	
	
	/**
	 * Returns the rotate speed of the {@code IPhysical}.
	 * 
	 * @return  a rotate velocity
	 * 
	 * 
	 * @see Spin
	 */
	public default Spin RotSpeed()
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