package waffles.utils.phys.drones;

import waffles.utils.phys.Dynamical;
import waffles.utils.phys.utilities.sets.Impact;
import waffles.utils.sets.mutable.JHashSet;

/**
 * A {@code Detectable} object defines collision detection dynamics.
 *
 * @author Waffles
 * @since 05 Sep 2024
 * @version 1.0
 *
 * 
 * @see Dynamical
 */
public interface Detectable extends Dynamical
{
	/**
	 * A {@code Detectable.Dynamics} defines a list
	 * which contains an object's active collisions.
	 *
	 * @author Waffles
	 * @since 05 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Dynamical
	 */
	public static interface Dynamics extends Dynamical.Dynamics
	{
		/**
		 * Returns the impacts of the {@code Detectable.Dynamics}.
		 * 
		 * @return  an impact set
		 * 
		 * 
		 * @see JHashSet
		 * @see Impact
		 */
		public abstract JHashSet<Impact> Detects();
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}
