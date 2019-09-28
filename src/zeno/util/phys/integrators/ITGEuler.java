package zeno.util.phys.integrators;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.phys.IDynamics;
import zeno.util.phys.IPhysical;
import zeno.util.phys.Integrator;
import zeno.util.tools.patterns.Decorator;

/**
 * The {@code ITGEuler} interface integrates using the {@code semi-implicit Euler method}.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see Integrator
 */
public interface ITGEuler extends Decorator<IPhysical>, Integrator
{	
	@Override
	public default void onUpdate(long dt)
	{			
		IDynamics dyns = Delegate().Dynamics();
		
		
		// Compute the new distance vectors.
		Vector vLin = dyns.LinSpeed().times(dt);
		Vector vRot = dyns.RotSpeed().times(dt);
		
		// Update the state of the object.
		Delegate().rotateFor(vRot);
		Delegate().moveFor(vLin);
		
		
		// Compute the velocity scales.
		float sLin = dt / dyns.Mass();
		float sRot = dt / dyns.Inertia();
		
		// Update the object's velocity.
		dyns.addRotSpeed(Torque().times(sRot));
		dyns.addLinSpeed(Force().times(sLin));
	}
	
	
	/**
	 * Returns the total torque in the {@code ITGEuler}.
	 * 
	 * @return  a torque vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector Torque();

	/**
	 * Returns the total force in the {@code ITGEuler}.
	 * 
	 * @return  a force vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector Force();
}