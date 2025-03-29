package waffles.utils.phys.drones;

import waffles.utils.phys.drones.angular.types.Twistable2D;
import waffles.utils.phys.drones.linear.types.Powerable2D;

/**
 * A {@code PartialDynamical2D} object maintains partial dynamics in a two-dimensional space.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see PartialDynamical
 * @see Twistable2D
 * @see Powerable2D
 */
public interface PartialDynamical2D extends PartialDynamical, Twistable2D, Powerable2D
{
	// NOT APPLICABLE
}