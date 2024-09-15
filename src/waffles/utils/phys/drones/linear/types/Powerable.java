package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.data.unary.Powered;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code Powerable} object can maintain its own linear force.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Propellable
 * @see Powered
 */
public interface Powerable extends Propellable, Powered
{
	/**
	 * The {@code Powerable.Dynamics} updates the position of a {@code Drivable}
	 * through velocity verlet integration in classical mechanics.
	 *
	 * @author Waffles
	 * @since 19 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see Propellable
	 * @see Powered
	 */
	public static interface Dynamics extends Propellable.Dynamics, Powered.Mutable
	{
		@Override
		public abstract Powerable Drone();

		@Override
		public default void onIntegrate(long time)
		{
			float dt = time / 1000f;
			float fs = time * InvMass();
			
			Vector fLin = Drone().LinForce();
			Vector aLin = Drone().LinAccel();
			Vector vLin = Drone().LinSpeed();
			
			
			Vector aNew = fLin.times(fs);
			Vector fNew = aLin.plus(aNew).times(1f / 2);
			Vector xNew = vLin.plus(aLin.times(dt / 2));
			Vector vNew = fNew.times(dt);
			
			float sMax = MaxLinSpeed();
			float sLin = xNew.norm();
			
			if(sLin > sMax)
			{
				xNew = xNew.times(sMax / sLin);
			}
			
			xNew = xNew.times(dt);
			Drone().propelTo(aNew);
			Drone().speedFor(vNew);
			Drone().moveFor(xNew);
		}
	}


	/**
	 * Powers the {@code Powerable} to a linear vector.
	 * 
	 * @param f  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public default void powerTo(Vector f)
	{
		Dynamics().setLinForce(f);
	}
		
	/**
	 * Powers the {@code Powerable} for a linear vector.
	 * 
	 * @param f  a linear force
	 * @param s  a force scale
	 * 
	 * 
	 * @see Vector
	 */
	public default void powerFor(Vector f, float s)
	{
		if(!Floats.isZero(s, 1))
		{
			powerFor(f.normalize().times(s));
		}
	}
	
	/**
	 * Powers the {@code Powerable} for a linear vector.
	 * 
	 * @param f  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public default void powerFor(Vector f)
	{
		powerTo(LinForce().plus(f));
	}

	
	@Override
	public abstract Dynamics Dynamics();

	@Override
	public default Vector LinForce()
	{
		return Dynamics().LinForce();
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