package waffles.utils.phys.drones;

import waffles.utils.phys.Dynamical;
import waffles.utils.phys.utilities.sets.CycledSet;
import waffles.utils.phys.utilities.sets.Impact;

/**
 * An {@code Impactable} object defines impact resolution dynamics.
 *
 * @author Waffles
 * @since 05 Sep 2024
 * @version 1.0
 *
 * 
 * @see Dynamical
 */
public interface Impactable extends Dynamical
{
	/**
	 * An {@code Impactable.Dynamics} defines a cycled set
	 * which contains an object's active impacts.
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
		 * Returns the impacts of the {@code Impactable.Dynamics}.
		 * 
		 * @return  an impact set
		 * 
		 * 
		 * @see CycledSet
		 * @see Impact
		 */
		public abstract CycledSet<Impact> Impacts();
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}
