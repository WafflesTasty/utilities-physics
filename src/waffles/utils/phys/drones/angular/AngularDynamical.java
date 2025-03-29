package waffles.utils.phys.drones.angular;

import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.angular.data.Orbit;
import waffles.utils.phys.drones.angular.types.Orbitable;
import waffles.utils.tools.primitives.Floats;

/**
 * An {@code AngularDynamical} object refreshes its own angular force on each update
 * of its {@code Dynamics}. This allows the object to be used in torque computation
 * algorithms, which generate a new torque vector with each update.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Orbitable
 */
public interface AngularDynamical extends Orbitable
{
	/**
	 * The {@code AngularDynamical.Dynamics} refreshes its angular force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Orbitable
	 */
	public static class Dynamics extends Orbit implements Orbitable.Dynamics
	{
		private float vMax;
		private AngularDynamical drone;
		
		/**
		 * Creates a new {@code AngularDynamical.Dynamics}.
		 * 
		 * @param d  a target drone
		 */
		public Dynamics(AngularDynamical d)
		{
			super(d.Dimension());
			vMax = Floats.MAX_VALUE;
			drone = d;
		}

		/**
		 * Changes the max speed of the {@code AngularDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxAngSpeed(float max)
		{
			vMax = max;
		}
		
		
		@Override
		public void onUpdate(long time)
		{
			Orbitable.Dynamics.super.onUpdate(time);
			setAngForce(Vectors.create(Dimension()));
		}

		@Override
		public AngularDynamical Drone()
		{
			return drone;
		}
		
		@Override
		public float MaxAngSpeed()
		{
			return vMax;
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}