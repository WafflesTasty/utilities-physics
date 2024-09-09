package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.spatial.types.Movable;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.drones.linear.data.unary.Driven;
import waffles.utils.phys.utilities.events.SynchroEvent;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Drivable} object can maintain its own linear speed.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Dynamical
 * @see Movable
 * @see Driven
 */
public interface Drivable extends Dynamical, Driven, Movable
{
	/**
	 * The {@code Drivable.Dynamics} updates the position of a {@code Drivable}
	 * through basic linear integration according to a speed vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see SynchroEvent
	 * @see Driven
	 */
	public static interface Dynamics extends Dynamical.Dynamics, Driven.Mutable
	{
		/**
		 * Returns the drone of the {@code Dynamics}.
		 * 
		 * @return  a parent drone
		 * 
		 * 
		 * @see Drivable
		 */
		public abstract Drivable Drone();
		
		/**
		 * An event raised on integrating the {@code Dynamics}.
		 * 
		 * @param time  a time interval (in ms)
		 */
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			
			Vector vLin = LinSpeed();
			float sMax = MaxLinSpeed();
			float sLin = vLin.norm();
			
			if(sLin < sMax)
			{
				vLin = vLin.times(sMax / sLin);
			}
			
			
			vLin = vLin.times(dt);
			Drone().moveFor(vLin);			
		}
		
		/**
		 * Returns the maximum linear speed of the {@code Driven}.
		 * 
		 * @return  a maximum speed
		 */
		public default float MaxLinSpeed()
		{
			return Floats.MAX_VALUE;
		}
		
		
		@Override
		public default void onUpdate(long time)
		{
			onIntegrate(time);
		}
	}
		
	
	/**
	 * Speeds the {@code Drivable} to a linear vector.
	 * 
	 * @param v  a linear speed
	 * 
	 * 
	 * @see Vector
	 */
	public default void speedTo(Vector v)
	{
		Dynamics().setLinSpeed(v);
	}
		
	/**
	 * Speeds the {@code Drivable} for a linear vector.
	 * 
	 * @param v  a linear speed
	 * @param s  a speed scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void speedFor(Vector v, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			speedFor(v.normalize().times(s));
		}
	}
	
	/**
	 * Speeds the {@code Drivable} for a linear vector.
	 * 
	 * @param v  a linear speed
	 * 
	 * 
	 * @see Vector
	 */
	public default void speedFor(Vector v)
	{
		speedTo(LinSpeed().plus(v));
	}
	
	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector LinSpeed()
	{
		return Dynamics().LinSpeed();
	}
	
	@Override
	public default int Dimension()
	{
		return Dynamics().Dimension();
	}
}