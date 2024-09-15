package waffles.utils.phys.drones.linear;

import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.linear.types.impact.ImpactPowerable;
import waffles.utils.phys.utilities.sets.CycledSet;

/**
 * A {@code LinearImpactable} object is {@code LinearDynamical} with an impact set.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see ImpactPowerable
 * @see LinearDynamical
 */
public interface LinearImpactable extends LinearDynamical, ImpactPowerable
{
	/**
	 * The {@code LinearDynamical.Dynamics} refreshes its linear force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see ImpactPowerable
	 * @see LinearDynamical
	 */
	public static class Dynamics extends LinearDynamical.Dynamics implements ImpactPowerable.Dynamics
	{
		private CycledSet<Impactable> impacts;

		/**
		 * Creates a new {@code LinearImpactable.Dynamics}.
		 * 
		 * @param d  a target drone
		 * 
		 * 
		 * @see LinearImpactable
		 */
		public Dynamics(LinearImpactable d)
		{
			super(d);
			impacts = new CycledSet<>();
		}
		

		@Override
		public CycledSet<Impactable> Impacts()
		{
			return impacts;
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}