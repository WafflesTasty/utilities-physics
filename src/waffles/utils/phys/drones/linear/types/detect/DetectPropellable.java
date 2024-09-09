package waffles.utils.phys.drones.linear.types.detect;

import waffles.utils.phys.drones.Detectable;
import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.linear.types.Propellable;

/**
 * A {@code DetectPropellable} object can be propelled and detected.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Propellable
 * @see Detectable
 */
public interface DetectPropellable extends Propellable, Detectable
{
	/**
	 * The {@code DetectPropellable.Dynamics} combine propellable and detecable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Detectable
	 * @see Impactable
	 */
	public static interface Dynamics extends Propellable.Dynamics, Detectable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}