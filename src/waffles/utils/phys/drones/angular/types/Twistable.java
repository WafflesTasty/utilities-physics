package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.unary.Twisted;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Twistable} object can maintain its own angular acceleration.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Screwable
 * @see Twisted
 */
public interface Twistable extends Screwable, Twisted
{
	/**
	 * The {@code Twistable.Dynamics} updates the rotation of a {@code Screwable}
	 * through basic linear integration according to a speed and acceleration vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Screwable
	 * @see Twisted
	 */
	public static interface Dynamics extends Screwable.Dynamics, Twisted.Mutable
	{
		@Override
		public abstract Twistable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float ddt = dt * dt / 2;
			
			Spin aAng = AngAccel();
			Spin vAng = AngSpeed();

			
			Spin vNew = aAng.times(dt);
			Spin xDif = aAng.times(dt / 2);
			Spin xNew = vAng.compose(xDif);
			
			float sMax = MaxAngSpeed();
			float sLin = xNew.MaxAngle();

			if(sMax < sLin)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			
			xNew = xNew.times(dt);
			Drone().screwFor(vNew);
			Drone().rotateFor(xNew);
		}
	}
	
	
	/**
	 * Twists the {@code Twistable} to an angular spin.
	 * 
	 * @param a  an angular acceleration
	 * 
	 * 
	 * @see Spin
	 */
	public default void twistTo(Spin a)
	{
		Dynamics().setAngAccel(a);
	}
		
	/**
	 * Twists the {@code Twistable} for an angular spin.
	 * 
	 * @param a  an angular acceleration
	 * @param s  an acceleration scale
	 * 
	 * 
	 * @see Spin
	 */
	public default void twistFor(Spin a, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			float ang = a.MaxAngle();
			twistFor(a.times(s / ang));
		}
	}
	
	/**
	 * Twists the {@code Twistable} for an angular spin.
	 * 
	 * @param a  an angular acceleration
	 * 
	 * 
	 * @see Spin
	 */
	public default void twistFor(Spin a)
	{
		twistTo(AngAccel().compose(a));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Spin AngAccel()
	{
		return Dynamics().AngAccel();
	}
}