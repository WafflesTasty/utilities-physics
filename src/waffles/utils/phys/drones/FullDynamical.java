package waffles.utils.phys.drones;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.geom.spatial.data.Spatial;
import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.Orbit;
import waffles.utils.phys.drones.angular.types.Orbitable;
import waffles.utils.phys.drones.linear.data.Tractor;
import waffles.utils.phys.drones.linear.types.Powerable;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code FullDynamical} object refreshes its own forces on each update
 * of its {@code Dynamics}. This allows the object to be used in computation
 * algorithms, which generate new force vectors with each update.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Orbitable
 * @see Powerable
 */
public interface FullDynamical extends Orbitable, Powerable
{
	/**
	 * The {@code LinearDynamical.Dynamics} refreshes its linear force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Orbitable
	 * @see Powerable
	 */
	public static class Dynamics implements Orbitable.Dynamics, Powerable.Dynamics
	{
		private float lMax, aMax;
		private FullDynamical drone;
		private Tractor tractor;
		private Orbit orbit;
		
		/**
		 * Creates a new {@code FullDynamical.Dynamics}.
		 * 
		 * @param d  a target drone
		 * 
		 * 
		 * @see FullDynamical
		 */
		public Dynamics(FullDynamical d)
		{
			tractor = new Tractor(d.Dimension());
			orbit = new Orbit(d.Dimension());
			lMax = Floats.MAX_VALUE;
			aMax = Floats.MAX_VALUE;
			drone = d;
		}

		/**
		 * Changes the max linear speed of the {@code FullDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxLinSpeed(float max)
		{
			lMax = max;
		}
		
		/**
		 * Changes the max angular speed of the {@code FullDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxAngSpeed(float max)
		{
			aMax = max;
		}

		
		@Override
		public void onUpdate(long time)
		{
			onIntegrate(time);
			setLinForce(Vectors.create(Dimension()));
			setAngForce(Vectors.create(Dimension()));
		}
		
		@Override
		public void onIntegrate(long time)
		{
			Orbitable.Dynamics.super.onIntegrate(time);
			Powerable.Dynamics.super.onIntegrate(time);
		}

		
		@Override
		public void setLinSpeed(Vector v)
		{
			tractor.setLinSpeed(v);
		}
		
		@Override
		public void setLinAccel(Vector a)
		{
			tractor.setLinAccel(a);
		}
		
		@Override
		public void setLinForce(Vector f)
		{
			tractor.setLinForce(f);
		}
		
		@Override
		public void setAngSpeed(Spin s)
		{
			orbit.setAngSpeed(s);
		}

		@Override
		public void setAngAccel(Spin a)
		{
			orbit.setAngAccel(a);
		}

		@Override
		public void setAngForce(Vector f)
		{
			orbit.setAngForce(f);
		}

		@Override
		public void setInertia(float i)
		{
			orbit.setInertia(i);
		}
		
		@Override
		public void setMass(float m)
		{
			tractor.setMass(m);
		}

		
		@Override
		public float MaxLinSpeed()
		{
			return lMax;
		}
		
		@Override
		public float MaxAngSpeed()
		{
			return aMax;
		}

		@Override
		public FullDynamical Drone()
		{
			return drone;
		}
		
		@Override
		public Vector LinSpeed()
		{
			return tractor.LinSpeed();
		}
		
		@Override
		public Vector LinAccel()
		{
			return tractor.LinAccel();
		}
		
		@Override
		public Vector LinForce()
		{
			return tractor.LinForce();
		}
		
		@Override
		public Vector AngForce()
		{
			return orbit.AngForce();
		}
		
		@Override
		public Spin AngSpeed()
		{
			return orbit.AngSpeed();
		}
		
		@Override
		public Spin AngAccel()
		{
			return orbit.AngAccel();
		}

		@Override
		public int Dimension()
		{
			return tractor.Dimension();
		}
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
	
	@Override
	public abstract Spatial.Mutable Transform();

	@Override
	public default int Dimension()
	{
		return Dynamics().Dimension();
	}
}