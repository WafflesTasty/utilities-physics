package waffles.utils.phys.physical;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.dynamics.LinearDynamical;
import waffles.utils.phys.dynamics.LinearDynamics;

/**
 * A {@code LinearPhysical} object can handle linear kinetics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see LinearDynamics
 */
public interface LinearPhysical extends LinearDynamical.Mutable
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
	public default void setLinImpulse(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setLinImpulse(v);
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
	public default Vector LinImpulse()
	{
		return Dynamics().LinImpulse();
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