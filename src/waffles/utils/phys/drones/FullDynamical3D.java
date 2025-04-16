package waffles.utils.phys.drones;

import waffles.utils.phys.drones.angular.types.Orbitable3D;
import waffles.utils.phys.drones.linear.types.Powerable3D;
import waffles.utils.phys.drones.scalar.types.Pressable3D;

/**
 * A {@code FullDynamical3D} object maintains full dynamics in a three-dimensional space.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see FullDynamical
 * @see Pressable3D
 * @see Orbitable3D
 * @see Powerable3D
 */
public interface FullDynamical3D extends FullDynamical, Orbitable3D, Powerable3D, Pressable3D
{
	// NOT APPLICABLE
}