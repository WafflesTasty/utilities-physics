package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.data.unary.Propelled;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Propellable} object can maintain its own linear acceleration.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Propelled
 * @see Drivable
 */
public interface Propellable extends Drivable, Propelled
{
	/**
	 * The {@code Propellable.Dynamics} updates the position of a {@code Drivable}
	 * through basic linear integration according to a speed and acceleration vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Propelled
	 * @see Drivable
	 */
	public static interface Dynamics extends Drivable.Dynamics, Propelled.Mutable
	{
		@Override
		public abstract Propellable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float ddt = dt * dt / 2;
			
			Vector aLin = LinAccel();
			Vector vLin = LinSpeed();

			
			Vector vNew = aLin.times(dt);
			Vector xDif = aLin.times(dt / 2);
			Vector xNew = vLin.plus(xDif);
			
			float sMax = MaxLinSpeed();
			float sLin = xNew.norm();
			
			if(sLin < sMax)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			
			xNew = xNew.times(dt);
			Drone().speedFor(vNew);
			Drone().moveFor(xNew);
		}
	}
	
	
	/**
	 * Propels the {@code Drivable} to a linear vector.
	 * 
	 * @param a  a linear acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public default void propelTo(Vector a)
	{
		Dynamics().setLinAccel(a);
	}
		
	/**
	 * Propels the {@code Drivable} for a linear vector.
	 * 
	 * @param a  a linear acceleration
	 * @param s  an acceleration scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void propelFor(Vector a, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			propelFor(a.normalize().times(s));
		}
	}
	
	/**
	 * Propels the {@code Drivable} for a linear vector.
	 * 
	 * @param a  a linear acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public default void propelFor(Vector a)
	{
		propelTo(LinAccel().plus(a));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector LinAccel()
	{
		return Dynamics().LinAccel();
	}
}