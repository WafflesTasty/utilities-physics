package zeno.util.phys.integrate;

import waffles.util.tools.patterns.semantics.Decorator;
import zeno.util.algebra.linear.vector.fixed.Vector2;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.phys.Integrator;
import zeno.util.phys.entities.IPhysical2D;

/**
 * The {@code ITGEuler2D} interface integrates 2D objects using the {@code semi-implicit Euler method}.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see IPhysical2D
 * @see Integrator
 * @see Decorator
 */
public interface ITGEuler2D extends Decorator<IPhysical2D>, Integrator
{	
	@Override
	public default void onUpdate(long dt)
	{			
		IPhysical2D tgt = Delegate();

		// Compute the new distance vectors.
		Vector2 vLin = tgt.LinSpeed().times(dt / 1000f);
		Vector3 vRot = tgt.RotSpeed().times(dt / 1000f);

		// Update the state of the object.
		tgt.rotateFor(vRot.Z());
		tgt.moveFor(vLin);
		
		
		// Compute the velocity scales.
		float sLin = dt / tgt.Mass();
		float sRot = dt / tgt.Inertia();
		
		// Update the object's velocity.
		tgt.addLinSpeed(Force().times(sLin));
		tgt.addRotSpeed(Torque() * sRot);
	}
	
	
	/**
	 * Returns the total force in the {@code ITGEuler2D}.
	 * 
	 * @return  a force vector
	 * 
	 * 
	 * @see Vector2
	 */
	public abstract Vector2 Force();
	
	/**
	 * Returns the total torque in the {@code ITGEuler2D}.
	 * 
	 * @return  a torque value
	 */
	public abstract float Torque();
}