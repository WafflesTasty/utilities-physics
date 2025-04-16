package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.scalar.data.unary.Wedged;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Wedgable} object can maintain its own scalar acceleration.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Pinchable
 * @see Wedged
 */
public interface Wedgable extends Pinchable, Wedged
{
	/**
	 * The {@code Wedgable.Dynamics} updates the scale of a {@code Wedgable}
	 * through basic linear integration according to a speed and acceleration vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Pinchable
	 * @see Wedged
	 */
	public static interface Dynamics extends Pinchable.Dynamics, Wedged.Mutable
	{
		@Override
		public abstract Wedgable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float ddt = dt * dt / 2;
			
			Vector aLin = PinAccel();
			Vector vLin = PinSpeed();

			
			Vector vNew = aLin.times(dt);
			Vector xDif = aLin.times(dt / 2);
			Vector xNew = vLin.plus(xDif);
			
			float sMax = MaxPinSpeed();
			float sLin = xNew.norm();
			int dim = vLin.Size();
			
			if(sMax < sLin)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			
			xNew = xNew.times(dt);
			for(int i = 0; i < xNew.Size(); i++)
			{
				float x = xNew.get(i);
				x = Floats.pow(Floats.EULER, x / 2);
				vLin.set(x, i);
			}

			Drone().pinchFor(vNew);
			Drone().scaleFor(xNew);
		}
	}
	
	
	/**
	 * Wedges the {@code Drivable} to a scalar vector.
	 * 
	 * @param a  a scalar acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public default void wedgeTo(Vector a)
	{
		Dynamics().setPinAccel(a);
	}
		
	/**
	 * Wedges the {@code Drivable} for a scalar vector.
	 * 
	 * @param a  a scalar acceleration
	 * @param s  an acceleration scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void wedgeFor(Vector a, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			wedgeFor(a.normalize().times(s));
		}
	}
	
	/**
	 * Wedges the {@code Drivable} for a scalar vector.
	 * 
	 * @param a  a scalar acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public default void wedgeFor(Vector a)
	{
		wedgeTo(PinAccel().plus(a));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector PinAccel()
	{
		return Dynamics().PinAccel();
	}
}