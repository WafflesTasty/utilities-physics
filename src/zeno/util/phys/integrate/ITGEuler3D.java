package zeno.util.phys.integrate;

import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.utilities.spin.Spin3D;
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
		Vector3 vLin = tgt.LinSpeed().times(dt / 1000f);
		Spin3D vRot = tgt.RotSpeed().times(dt / 1000f);
		
		// Update the state of the object.
		tgt.rotateFor(vRot);
		tgt.moveFor(vLin);
		
		
		// Compute the velocity scales.
		float sLin = dt / tgt.Mass();
		float sRot = dt / tgt.Inertia();

		// Update the object's velocity.
		tgt.addLinSpeed(Force().times(sLin));
		tgt.addRotSpeed(Torque().times(sRot));
	}
	
	
	/**
	 * Returns the total force in the {@code ITGEuler3D}.
	 * 
	 * @return  a force vector
	 * 
	 * 
	 * @see Vector3
	 */
	public abstract Vector3 Force();

	/**
	 * Returns the total torque in the {@code ITGEuler3D}.
	 * 
	 * @return  a torque spin
	 * 
	 * 
	 * @see Spin3D
	 */
	public abstract Spin3D Torque();
}