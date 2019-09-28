package zeno.util.phys.integrate;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.phys.Integrator;
import zeno.util.phys.entities.IPhysical3D;
import zeno.util.tools.patterns.Decorator;

/**
 * The {@code ITGEuler3D} interface integrates 3D objects using the {@code semi-implicit Euler method}.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see IPhysical3D
 * @see Integrator
 * @see Decorator
 */
public interface ITGEuler3D extends Decorator<IPhysical3D>, Integrator
{	
	@Override
	public default void onUpdate(long dt)
	{			
		IPhysical3D tgt = Delegate();

		// Compute the new distance vectors.
		Vector3 vLin = tgt.LinSpeed().times(dt);
		Vector3 vRot = tgt.RotSpeed().times(dt);
		
		// Update the state of the object.
		tgt.rotateFor(vRot);
		tgt.moveFor(vLin);
		
		
		// Compute the velocity scales.
		float sLin = dt / tgt.Mass();
		float sRot = dt / tgt.Inertia();
		
		// Update the object's velocity.
		tgt.rotateSpeedFor(Torque().times(sRot));
		tgt.linearSpeedFor(Force().times(sLin));
	}
	
	
	/**
	 * Returns the total torque in the {@code ITGEuler}.
	 * 
	 * @return  a torque vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector3 Torque();

	/**
	 * Returns the total force in the {@code ITGEuler}.
	 * 
	 * @return  a force vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector3 Force();
}