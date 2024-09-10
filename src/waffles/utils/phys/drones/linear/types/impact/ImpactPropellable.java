package waffles.utils.phys.drones.linear.types.impact;

import waffles.utils.phys.drones.linear.types.Propellable;

/**
 * An {@code ImpactPropellable} object can be propelled and impacted.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see ImpactDrivable
 * @see Propellable
 */
public interface ImpactPropellable extends ImpactDrivable, Propellable
{
	/**
	 * The {@code ImpactPropellable.Dynamics} combine propellable and impactable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see ImpactDrivable
	 * @see Propellable
	 */
	public static interface Dynamics extends ImpactDrivable.Dynamics, Propellable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}