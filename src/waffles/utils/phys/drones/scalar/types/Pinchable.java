package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.geom.spatial.types.Scalable;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.drones.linear.data.unary.Driven;
import waffles.utils.phys.drones.scalar.data.unary.Pinched;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Pinchable} object can maintain its own scalar speed.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Dynamical
 * @see Scalable
 * @see Pinched
 */
public interface Pinchable extends Dynamical, Pinched, Scalable
{
	/**
	 * The {@code Pinchable.Dynamics} updates the scale of a {@code Pinchable}
	 * through basic linear integration according to a speed vector.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Dynamical
	 * @see Driven
	 */
	public static interface Dynamics extends Dynamical.Dynamics, Pinched.Mutable
	{	
		/**
		 * Returns the max scalar speed of the {@code Dynamics}.
		 * 
		 * @return  a maximum speed
		 */
		public default float MaxPinSpeed()
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
			
			Vector vLin = PinSpeed();
			float sMax = MaxPinSpeed();
			float sLin = vLin.norm();
			int dim = vLin.Size();
			
			if(sMax < sLin)
			{
				vLin = vLin.times(sMax / sLin);
			}
			
			Vector one = Vectors.create(1f, dim);
			vLin = one.plus(vLin.times(dt));			
			Drone().scaleFor(vLin);			
		}
				
		
		@Override
		public default void onUpdate(long time)
		{
			onIntegrate(time);
		}

		@Override
		public abstract Pinchable Drone();
	}
		
	
	/**
	 * Pinches the {@code Pinchable} to a scalar vector.
	 * 
	 * @param v  a scalar speed
	 * 
	 * 
	 * @see Vector
	 */
	public default void pinchTo(Vector v)
	{
		Dynamics().setPinSpeed(v);
	}
		
	/**
	 * Pinches the {@code Pinchable} for a scalar vector.
	 * 
	 * @param v  a scalar speed
	 * @param s  a speed scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void pinchFor(Vector v, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			pinchFor(v.normalize().times(s));
		}
	}
	
	/**
	 * Pinches the {@code Pinchable} for a scalar vector.
	 * 
	 * @param v  a scalar speed
	 * 
	 * 
	 * @see Vector
	 */
	public default void pinchFor(Vector v)
	{
		pinchTo(PinSpeed().plus(v));
	}
	
	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector PinSpeed()
	{
		return Dynamics().PinSpeed();
	}
	
	@Override
	public default int Dimension()
	{
		return Dynamics().Dimension();
	}
}