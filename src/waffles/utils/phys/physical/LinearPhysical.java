package waffles.utils.phys.physical;

import waffles.utils.algebra.elements.linear.vector.Vector;
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
public interface LinearPhysical extends LinearDynamics
{
	/**
	 * Returns the dynamics of the {@code LinearPhysical}.
	 * 
	 * @return  a linear mutable
	 * 
	 * 
	 * @see LinearDynamics
	 */
	public abstract LinearDynamics.Mutable Dynamics();
	
	
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