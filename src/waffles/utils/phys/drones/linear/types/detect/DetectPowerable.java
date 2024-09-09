package waffles.utils.phys.drones.linear.types.detect;

import waffles.utils.phys.drones.Detectable;
import waffles.utils.phys.drones.linear.types.Powerable;

/**
 * A {@code DetectPowerable} object can be powered and detected.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Detectable
 * @see Powerable
 */
public interface DetectPowerable extends Powerable, Detectable
{
	/**
	 * The {@code DetectPowerable.Dynamics} combine powerable and detectable dynamics.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Detectable
	 * @see Powerable
	 */
	public static interface Dynamics extends Powerable.Dynamics, Detectable.Dynamics
	{
		// NOT APPLICABLE
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}