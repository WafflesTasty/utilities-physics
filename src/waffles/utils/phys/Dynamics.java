package waffles.utils.phys;

import waffles.utils.phys.dynamics.AngularDynamics;
import waffles.utils.phys.dynamics.LinearDynamics;

/**
 * A {@code Dynamics} object defines a linear and angular speed, inertia and mass.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamics
 * @see LinearDynamics
 */
public interface Dynamics extends LinearDynamics, AngularDynamics
{
	/**
	 * A {@code Mutable Dynamics} object can change its own speed, inertia and mass.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 *
	 * 
	 * @see AngularDynamics
	 * @see LinearDynamics
	 */
	public static interface Mutable extends LinearDynamics.Mutable, AngularDynamics.Mutable
	{
		// NOT APPLICABLE
	}
}