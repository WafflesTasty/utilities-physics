package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.angular.data.unary.Orbital;
import waffles.utils.tools.errors.NotImplementedError;
import waffles.utils.tools.primitives.Floats;

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
			// TODO: Rotational integration via torque.
			throw new NotImplementedError();
			
			/*
			float dt = time / 1000f;
			float fs = time * InvInertia();
			
			Vector fLin = Drone().LinForce();
			Vector aLin = Drone().LinAccel();
			Vector vLin = Drone().LinSpeed();
			
			
			Vector aNew = fLin.times(fs);
			Vector fNew = aLin.plus(aNew).times(1f / 2);
			Vector xNew = vLin.plus(aLin.times(dt / 2));
			Vector vNew = fNew.times(dt);
			
			float sMax = MaxLinSpeed();
			float sLin = xNew.norm();
			
			if(sMax > sLin)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			xNew = xNew.times(dt);
			Drone().propelTo(aNew);
			Drone().speedFor(vNew);
			Drone().moveFor(xNew);
			*/
		}
	}


	/**
	 * Orbits the {@code Orbitable} to an angular vector.
	 * 
	 * @param f  an angular force
	 * 
	 * 
	 * @see Vector
	 */
	public default void orbitTo(Vector f)
	{
		Dynamics().setAngForce(f);
	}
		
	/**
	 * Orbits the {@code Orbitable} for an angular vector.
	 * 
	 * @param f  an angular force
	 * @param s  a force scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void orbitFor(Vector f, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			orbitFor(f.normalize().times(s));
		}
	}
	
	/**
	 * Orbits the {@code Orbitable} for a angular vector.
	 * 
	 * @param f  an angular force
	 * 
	 * 
	 * @see Vector
	 */
	public default void orbitFor(Vector f)
	{
		orbitTo(AngForce().plus(f));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector AngForce()
	{
		return Dynamics().AngForce();
	}
	
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