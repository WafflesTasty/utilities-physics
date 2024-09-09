package waffles.utils.phys.drones.linear;

import waffles.utils.phys.drones.linear.types.detect.DetectPowerable;
import waffles.utils.phys.utilities.sets.Impact;
import waffles.utils.sets.mutable.JHashSet;

/**
 * A {@code LinearDetectable} object is {@code LinearDynamical} with a collision set.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see DetectPowerable
 * @see LinearDynamical
 */
public interface LinearDetectable extends LinearDynamical, DetectPowerable
{
	/**
	 * The {@code LinearDynamical.Dynamics} refreshes its linear force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see DetectPowerable
	 * @see LinearDynamical
	 */
	public static class Dynamics extends LinearDynamical.Dynamics implements DetectPowerable.Dynamics
	{
		private JHashSet<Impact> detects;

		/**
		 * Creates a new {@code LinearImpactable.Dynamics}.
		 * 
		 * @param d  a target drone
		 * 
		 * 
		 * @see LinearDetectable
		 */
		public Dynamics(LinearDetectable d)
		{
			super(d);
			detects = new JHashSet<>();
		}
		

		@Override
		public JHashSet<Impact> Detects()
		{
			return detects;
		}
		
		@Override
		public void onUpdate(long time)
		{
			super.onUpdate(time);
			detects.clear();
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}