package zeno.util.phys;

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