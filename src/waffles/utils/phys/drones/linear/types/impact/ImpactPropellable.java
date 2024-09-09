package waffles.utils.phys.drones.linear.types.impact;

import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.linear.types.Propellable;

/**
 * An {@code ImpactPropellable} object can be propelled and impacted.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Propellable
 * @see Impactable
 */
public interface ImpactPropellable extends Propellable, Impactable
{
	/**
	 * The {@code ImpactPropellable.Dynamics} combine propellable and impactable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Propellable
	 * @see Impactable
	 */
	public static interface Dynamics extends Propellable.Dynamics, Impactable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}