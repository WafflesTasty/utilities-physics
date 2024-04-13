package waffles.utils.phys.physical;

import waffles.utils.phys.physical.angular.AngularPhysical3D;
import waffles.utils.phys.physical.linear.LinearPhysical3D;

/**
 * A {@code Kinetical3D} defines a three-dimensional object with general Newtonian physics.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 * 
 * @see AngularPhysical3D
 * @see LinearPhysical3D
 * @see Kinetical
 */
public interface Kinetical3D extends Kinetical, AngularPhysical3D, LinearPhysical3D
{
	// NOT APPLICABLE
}