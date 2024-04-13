package zeno.util.phys.integrate;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector3;
import waffles.utils.phys._deprecated.IPhysical3D;
import waffles.utils.tools.patterns.semantics.Decorator;
import zeno.util.phys.events.SynchroEvent;

/**
 * The {@code ITGEuler3D} interface integrates 3D objects using the {@code semi-implicit Euler method}.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see SynchroEvent
 * @see Decorator
 */
public interface ITGEuler3D extends Decorator, SynchroEvent
{	
	@Override
	public default void onUpdate(long dt)
	{			
		IPhysical3D tgt = Delegate();

		// Compute the new distance vectors.
		Vector3 vLin = tgt.LinSpeed().times(dt / 1000f);
		Vector3 vRot = tgt.RotSpeed().times(dt / 1000f);
		
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
	 * @return  a torque vector
	 * 
	 * 
	 * @see Vector3
	 */
	public abstract Vector3 Torque();
}