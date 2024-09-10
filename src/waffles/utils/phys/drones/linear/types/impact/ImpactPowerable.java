package waffles.utils.phys.drones.linear.types.impact;

import waffles.utils.phys.drones.linear.types.Powerable;

/**
 * An {@code ImpactPowerable} object can be powered and impacted.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see ImpactPropellable
 * @see Powerable
 */
public interface ImpactPowerable extends ImpactPropellable, Powerable
{
	/**
	 * The {@code ImpactPowerable.Dynamics} combine powerable and impactable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see ImpactPropellable
	 * @see Powerable
	 */
	public static interface Dynamics extends ImpactPropellable.Dynamics, Powerable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}