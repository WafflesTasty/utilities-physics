package waffles.utils.phys.drones.linear;

import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.data.Machine;
import waffles.utils.phys.drones.linear.types.Powerable;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code LinearDynamical} object refreshes its own linear force on each update
 * of its {@code Dynamics}. This allows the object to be used in force computation
 * algorithms, which generate a new force vector with each update.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Powerable
 */
public interface LinearDynamical extends Powerable
{
	/**
	 * The {@code LinearDynamical.Dynamics} refreshes its linear force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Powerable
	 */
	public static class Dynamics extends Machine implements Powerable.Dynamics
	{
		private float vMax;
		private LinearDynamical drone;
		
		/**
		 * Creates a new {@code LinearDynamical.Dynamics}.
		 * 
		 * @param d  a target drone
		 */
		public Dynamics(LinearDynamical d)
		{
			super(d.Dimension());
			vMax = Floats.MAX_VALUE;
			drone = d;
		}

		/**
		 * Changes the max speed of the {@code LinearDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxLinSpeed(float max)
		{
			vMax = max;
		}
		
		
		@Override
		public void onUpdate(long time)
		{
			Powerable.Dynamics.super.onUpdate(time);
			setLinForce(Vectors.create(Dimension()));
		}

		@Override
		public LinearDynamical Drone()
		{
			return drone;
		}
		
		@Override
		public float MaxLinSpeed()
		{
			return vMax;
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}