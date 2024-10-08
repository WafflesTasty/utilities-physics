package waffles.utils.phys.drones.linear.types.impact;

import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.linear.types.Drivable;

/**
 * An {@code ImpactDrivable} object can be driven and impacted.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Impactable
 * @see Drivable
 */
public interface ImpactDrivable extends Drivable, Impactable
{
	/**
	 * The {@code ImpactDrivable.Dynamics} combine drivable and impactable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Impactable
	 * @see Drivable
	 */
	public static interface Dynamics extends Drivable.Dynamics, Impactable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}