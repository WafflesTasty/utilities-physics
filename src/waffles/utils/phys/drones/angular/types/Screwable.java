package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.geom.spatial.types.Rotatable;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.drones.angular.data.unary.Screwed;
import waffles.utils.tools.primitives.Floats;

/**
 * An {@code Screwable} object can maintain its own angular speed.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Dynamical
 * @see Rotatable
 * @see Screwed
 */
public interface Screwable extends Dynamical, Screwed, Rotatable
{
	/**
	 * The {@code Screwable.Dynamics} updates the rotation of an {@code Screwable}
	 * through basic linear integration according to a speed vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Dynamical
	 * @see Screwed
	 */
	public static interface Dynamics extends Dynamical.Dynamics, Screwed.Mutable
	{	
		/**
		 * Returns the max angular speed of the {@code Dynamics}.
		 * 
		 * @return  a maximum speed
		 */
		public default float MaxAngSpeed()
		{
			return Floats.MAX_VALUE;
		}
		
		/**
		 * An event raised on integrating the {@code Dynamics}.
		 * 
		 * @param time  a time interval (in ms)
		 */
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			
			Spin vAng = AngSpeed();
			float sMax = MaxAngSpeed();
			float sAng = vAng.MaxAngle();
			
			if(sMax < sAng)
			{
				vAng = vAng.times(sMax / sAng);
			}
			
			
			vAng = vAng.times(dt);
			Drone().rotateFor(vAng);			
		}
				
		
		@Override
		public default void onUpdate(long time)
		{
			onIntegrate(time);
		}

		@Override
		public abstract Screwable Drone();
	}
		
	
	/**
	 * Screws the {@code Screwable} to an angular spin.
	 * 
	 * @param v  an angular speed
	 * 
	 * 
	 * @see Spin
	 */
	public default void screwTo(Spin v)
	{
		Dynamics().setAngSpeed(v);
	}
		
	/**
	 * Screws the {@code Screwable} for an angular spin.
	 * 
	 * @param v  an angular speed
	 * @param s  a speed scale
	 * 
	 * 
	 * @see Spin
	 */
	public default void screwFor(Spin v, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			float a = v.MaxAngle();
			screwFor(v.times(s / a));
		}
	}
	
	/**
	 * Screws the {@code Screwable} for an angular spin.
	 * 
	 * @param v  an angular speed
	 * 
	 * 
	 * @see Spin
	 */
	public default void screwFor(Spin v)
	{
		screwTo(AngSpeed().compose(v));
	}
	
	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Spin AngSpeed()
	{
		return Dynamics().AngSpeed();
	}
	
	@Override
	public default int Dimension()
	{
		return Dynamics().Dimension();
	}
}