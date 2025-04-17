package waffles.utils.phys.drones.scalar.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.scalar.data.unary.Squeezed;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Pressable} object can maintain its own scalar force.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Squeezed
 * @see Wedgable
 */
public interface Pressable extends Wedgable, Squeezed
{
	/**
	 * The {@code Pressable.Dynamics} updates the scale of a {@code Pressable}
	 * through velocity verlet integration in classical mechanics.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Wedgable
	 * @see Squeezed
	 */
	public static interface Dynamics extends Wedgable.Dynamics, Squeezed.Mutable
	{
		@Override
		public abstract Pressable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float fs = time * InvMass();
			
			Vector fLin = Drone().PinForce();
			Vector aLin = Drone().PinAccel();
			Vector vLin = Drone().PinSpeed();
			
			
			Vector aNew = fLin.times(fs);
			Vector fNew = aLin.plus(aNew).times(1f / 2);
			Vector xNew = vLin.plus(aLin.times(dt / 2));
			Vector vNew = fNew.times(dt);
			
			float sMax = MaxPinSpeed();
			float sLin = xNew.norm();
			int dim = vLin.Size();
			
			if(sMax < sLin)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			Vector one = Vectors.create(1f, dim);
			xNew = one.plus(xNew.times(dt));
			
			Drone().scaleFor(xNew);
			Drone().pinchFor(vNew);
			Drone().wedgeTo(aNew);
		}
	}


	/**
	 * Squeezes the {@code Powerable} to a scalar vector.
	 * 
	 * @param f  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public default void squeezeTo(Vector f)
	{
		Dynamics().setPinForce(f);
	}
		
	/**
	 * Squeezes the {@code Powerable} for a scalar vector.
	 * 
	 * @param f  a linear force
	 * @param s  a force scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void squeezeFor(Vector f, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			squeezeFor(f.normalize().times(s));
		}
	}
	
	/**
	 * Squeezes the {@code Powerable} for a scalar vector.
	 * 
	 * @param f  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public default void squeezeFor(Vector f)
	{
		squeezeTo(PinForce().plus(f));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector PinForce()
	{
		return Dynamics().PinForce();
	}
	
	@Override
	public default float InvMass()
	{
		return Dynamics().InvMass();
	}
	
	@Override
	public default float Mass()
	{
		return Dynamics().Mass();
	}
}