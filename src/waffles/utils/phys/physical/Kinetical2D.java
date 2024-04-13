package waffles.utils.phys.physical;

import waffles.utils.phys.physical.angular.AngularPhysical2D;
import waffles.utils.phys.physical.linear.LinearPhysical2D;

/**
 * A {@code Kinetical2D} defines a two-dimensional object with general Newtonian physics.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 * 
 * @see AngularPhysical2D
 * @see LinearPhysical2D
 * @see Kinetical
 */
public interface Kinetical2D extends Kinetical, AngularPhysical2D, LinearPhysical2D
{
	// NOT APPLICABLE
}