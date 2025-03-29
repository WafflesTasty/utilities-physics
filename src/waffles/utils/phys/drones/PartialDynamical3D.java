package waffles.utils.phys.drones;

import waffles.utils.phys.drones.angular.types.Twistable3D;
import waffles.utils.phys.drones.linear.types.Powerable3D;

/**
 * A {@code PartialDynamical3D} object maintains partial dynamics in a three-dimensional space.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see PartialDynamical
 * @see Twistable3D
 * @see Powerable3D
 */
public interface PartialDynamical3D extends PartialDynamical, Twistable3D, Powerable3D
{
	// NOT APPLICABLE
}