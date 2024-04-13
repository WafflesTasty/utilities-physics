package waffles.utils.phys.dynamics;

import waffles.utils.phys.dynamics.angular.AngularDynamical;
import waffles.utils.phys.dynamics.linear.LinearDynamical;

/**
 * A {@code Dynamical} object defines both linear and angular dynamics.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamical
 * @see LinearDynamical
 */
public interface Dynamical extends LinearDynamical, AngularDynamical
{
	/**
	 * A {@code Dynamical.Mutable} can change its own speed, mass and inertia.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see AngularDynamical
	 * @see LinearDynamical
	 * @see Dynamical
	 */
	public static interface Mutable extends LinearDynamical.Mutable, AngularDynamical.Mutable, Dynamical
	{
		// NOT APPLICABLE
	}
}
