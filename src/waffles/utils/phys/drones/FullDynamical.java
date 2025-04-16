package waffles.utils.phys.drones;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.geom.spatial.data.Spatial;
import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.Orbit;
import waffles.utils.phys.drones.angular.types.Orbitable;
import waffles.utils.phys.drones.linear.data.Tractor;
import waffles.utils.phys.drones.linear.types.Powerable;
import waffles.utils.phys.drones.scalar.data.Squeeze;
import waffles.utils.phys.drones.scalar.types.Pressable;
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
 * @see Pressable
 * @see Orbitable
 * @see Powerable
 */
public interface FullDynamical extends Orbitable, Powerable, Pressable
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
	public static class Dynamics implements Orbitable.Dynamics, Powerable.Dynamics, Pressable.Dynamics
	{
		private float lMax, sMax, aMax;
		private FullDynamical drone;
		private Squeeze press;
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
			press = new Squeeze(d.Dimension());
			tractor = new Tractor(d.Dimension());
			orbit = new Orbit(d.Dimension());
			
			lMax = Floats.MAX_VALUE;
			sMax = Floats.MAX_VALUE;
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
		 * Changes the max scalar speed of the {@code FullDynamical.Dynamics}.
		 * 
		 * @param max  a maximum speed
		 */
		public void setMaxPinSpeed(float max)
		{
			sMax = max;
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
			setAngForce(Spin.create(Dimension()));
			setLinForce(Vectors.create(Dimension()));
			setPinForce(Vectors.create(Dimension()));
		}
		
		@Override
		public void onIntegrate(long time)
		{
//			Pressable.Dynamics.super.onIntegrate(time);
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
		public void setPinSpeed(Vector v)
		{
			press.setPinSpeed(v);
		}
		
		@Override
		public void setPinAccel(Vector a)
		{
			press.setPinAccel(a);
		}
		
		@Override
		public void setPinForce(Vector f)
		{
			press.setPinForce(f);
		}
		
		@Override
		public void setAngSpeed(Spin s)
		{
			orbit.setAngSpeed(s);
		}

		@Override
		public void setAngAccel(Spin s)
		{
			orbit.setAngAccel(s);
		}

		@Override
		public void setAngForce(Spin s)
		{
			orbit.setAngForce(s);
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
		public float Mass()
		{
			return tractor.Mass();
		}
		
		@Override
		public float InvMass()
		{
			return tractor.InvMass();
		}
		
		@Override
		public float InvInertia()
		{
			return orbit.InvInertia();
		}
		
		@Override
		public float MaxLinSpeed()
		{
			return lMax;
		}
		
		@Override
		public float MaxPinSpeed()
		{
			return sMax;
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
		public Vector PinSpeed()
		{
			return press.PinSpeed();
		}
		
		@Override
		public Vector PinAccel()
		{
			return press.PinAccel();
		}
		
		@Override
		public Vector PinForce()
		{
			return press.PinForce();
		}
		
		@Override
		public Spin AngForce()
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
	public default float Mass()
	{
		return Dynamics().Mass();
	}
	
	@Override
	public default float InvMass()
	{
		return Dynamics().InvMass();
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