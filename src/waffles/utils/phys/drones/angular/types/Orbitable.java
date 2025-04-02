package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.unary.Orbital;

/**
 * An {@code Orbitable} object can maintain its own angular force.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Twistable
 * @see Orbital
 */
public interface Orbitable extends Twistable, Orbital
{
	/**
	 * The {@code Orbitable.Dynamics} updates the rotation of an {@code Orbitable}
	 * through velocity verlet integration in classical mechanics.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Twistable
	 * @see Orbital
	 */
	public static interface Dynamics extends Twistable.Dynamics, Orbital.Mutable
	{
		@Override
		public abstract Orbitable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float fs = time * InvInertia();
			
			Spin fRot = Drone().AngForce();
			Spin aRot = Drone().AngAccel();
			Spin vRot = Drone().AngSpeed();
			
			
			Spin aNew = fRot.times(fs);
			Spin fNew = aRot.compose(aNew).times(1f / 2);
			Spin xNew = vRot.compose(aRot.times(dt / 2));
			Spin vNew = fNew.times(dt);
			
			float sMax = MaxAngSpeed();
			float sRot = xNew.norm();
			
			if(sMax > sRot)
			{
				xNew = xNew.times(sMax / sRot);
			}
			
			xNew = xNew.times(dt);
			Drone().orbitTo(aNew);
			Drone().twistFor(vNew);
			Drone().screwFor(xNew);
		}
	}


	/**
	 * Orbits the {@code Orbitable} to an angular spin.
	 * 
	 * @param s  an angular force
	 * 
	 * 
	 * @see Spin
	 */
	public default void orbitTo(Spin s)
	{
		Dynamics().setAngForce(s);
	}

	/**
	 * Orbits the {@code Orbitable} for an angular spin.
	 * 
	 * @param s  an angular force
	 * 
	 * 
	 * @see Spin
	 */
	public default void orbitFor(Spin s)
	{
		orbitFor(AngForce().compose(s));
	}

	
	@Override
	public default Spin AngForce()
	{
		return Dynamics().AngForce();
	}
	
	@Override
	public abstract Dynamics Dynamics();
	
	@Override
	public default float InvInertia()
	{
		return Dynamics().InvInertia();
	}
	
	@Override
	public default float Inertia()
	{
		return Dynamics().Inertia();
	}
}