package waffles.utils.phys.drones;

import waffles.utils.phys.drones.angular.types.Orbitable2D;
import waffles.utils.phys.drones.linear.types.Powerable2D;
import waffles.utils.phys.drones.scalar.types.Pressable2D;

/**
 * A {@code FullDynamical2D} object maintains full dynamics in a two-dimensional space.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see FullDynamical
 * @see Pressable2D
 * @see Orbitable2D
 * @see Powerable2D
 */
public interface FullDynamical2D extends FullDynamical, Orbitable2D, Powerable2D, Pressable2D
{
	// NOT APPLICABLE
}