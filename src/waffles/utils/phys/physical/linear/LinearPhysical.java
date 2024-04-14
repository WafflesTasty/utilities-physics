package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collidable;
import waffles.utils.geom.spatial.types.Movable;
import waffles.utils.phys.dynamics.linear.LinearDynamical;

/**
 * A {@code LinearPhysical} defines a collidable object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see LinearDynamical
 * @see Collidable
 * @see Movable
 */
public interface LinearPhysical extends LinearDynamical.Mutable, Collidable, Movable
{
	/**
	 * Returns the dynamics of the {@code LinearPhysical}.
	 * 
	 * @return  a linear dynamics
	 * 
	 * 
	 * @see LinearDynamical
	 */
	public abstract LinearDynamical Dynamics();

	
	@Override
	public default void setLinForce(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setLinForce(v);
		}
	}
	
	@Override
	public default void setLinSpeed(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setLinSpeed(v);
		}
	}
	
	@Override
	public default void setMass(float m)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setMass(m);
		}
	}
	
	
	@Override
	public default Vector LinForce()
	{
		return Dynamics().LinForce();
	}
	
	@Override
	public default Vector LinSpeed()
	{
		return Dynamics().LinSpeed();
	}
	
	@Override
	public default float Mass()
	{
		return Dynamics().Mass();
	}
}