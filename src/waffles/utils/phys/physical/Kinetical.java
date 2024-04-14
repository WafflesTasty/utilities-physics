package waffles.utils.phys.physical;

import waffles.utils.geom.spatial.data.Spatial;
import waffles.utils.phys.dynamics.Dynamical;
import waffles.utils.phys.physical.angular.AngularPhysical;
import waffles.utils.phys.physical.linear.LinearPhysical;

/**
 * A {@code Kinetical} defines an object with general Newtonian physics.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularPhysical
 * @see LinearPhysical
 */
public interface Kinetical extends LinearPhysical, AngularPhysical
{
	@Override
	public abstract Spatial.Mutable Transform();
	
	@Override
	public abstract Dynamical Dynamics();
}