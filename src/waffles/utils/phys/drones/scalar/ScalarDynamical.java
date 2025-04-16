package waffles.utils.phys.drones.scalar;

import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.scalar.data.Squeeze;
import waffles.utils.phys.drones.scalar.types.Pressable;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code ScalarDynamical} object refreshes its own scalar force on each update
 * of its {@code Dynamics}. This allows the object to be used in force computation
 * algorithms, which generate a new force vector with each update.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Pressable
 */
public interface ScalarDynamical extends Pressable
{
	/**
	 * The {@code ScalarDynamical.Dynamics} refreshes its scalar force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Pressable
	 */
	public static class Dynamics extends Squeeze implements Pressable.Dynamics
	{
		private float vMax;
		private ScalarDynamical drone;
		
		/**
		 * Creates a new {@code ScalarDynamical.Dynamics}.
		 * 
		 * @param d  a target drone
		 */
		public Dynamics(ScalarDynamical d)
		{
			super(d.Dimension());
			vMax = Floats.MAX_VALUE;
			drone = d;
		}

		/**
		 * Changes the max speed of the {@code ScalarDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxPinSpeed(float max)
		{
			vMax = max;
		}
		
		
		@Override
		public void onUpdate(long time)
		{
			Pressable.Dynamics.super.onUpdate(time);
			setPinForce(Vectors.create(1f, Dimension()));
		}

		@Override
		public ScalarDynamical Drone()
		{
			return drone;
		}
		
		@Override
		public float MaxPinSpeed()
		{
			return vMax;
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}