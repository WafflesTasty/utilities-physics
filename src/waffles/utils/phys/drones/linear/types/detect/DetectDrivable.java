package waffles.utils.phys.drones.linear.types.detect;

import waffles.utils.phys.drones.Detectable;
import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.linear.types.Drivable;

/**
 * A {@code DetectDrivable} object can be driven and detected.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Detectable
 * @see Drivable
 */
public interface DetectDrivable extends Drivable, Detectable
{
	/**
	 * The {@code DetectDrivable.Dynamics} combine drivable and Detectable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Impactable
	 * @see Drivable
	 */
	public static interface Dynamics extends Drivable.Dynamics, Detectable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}