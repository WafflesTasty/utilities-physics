package zeno.util.phys.logic.euler;

import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.phys.logic.Integrator3D;
import zeno.util.phys.state.force.Force3D;
import zeno.util.phys.state.objects.IPhysical3D;

/**
 * The {@code Euler3D} class integrates using the {@code semi-implicit Euler method}.
 * <br> To apply drag to the object, override the {@link #calcLinDrag(Vector3)} and
 * {@link #calcRotDrag(Vector3)} methods to return a drag vector.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see Integrator3D
 */
public class Euler3D extends Integrator3D
{	
	private Vector3 fTotal;

	/**
	 * Creates a new {@code Euler3D}.
	 * 
	 * @param o  a target object
	 * @see IPhysical3D
	 */
	public Euler3D(IPhysical3D o)
	{
		super(o);
	}
	
	/**
	 * Calculates a drag vector caused by rotation.
	 * 
	 * @param v  a rotate speed vector
	 * @return  a drag force vector
	 * @see Vector3
	 */
	public Vector3 calcRotDrag(Vector3 v)
	{
		return new Vector3();
	}
	
	/**
	 * Calculates a drag vector caused by movement.
	 * 
	 * @param v  a linear speed vector
	 * @return  a drag force vector
	 * @see Vector3
	 */
	public Vector3 calcLinDrag(Vector3 v)
	{
		return new Vector3();
	}
	
	/**
	 * Adds rotate speed to the {@code Euler3D}.
	 * 
	 * @param v  a speed vector to add
	 * @see Vector3
	 */
	public void addAngSpeed(Vector3 v)
	{
		setRotSpeed(RotSpeed().plus(v));
	}
	
	/**
	 * Adds linear speed to the {@code Euler3D}.
	 * 
	 * @param v  a speed vector to add
	 * @see Vector3
	 */
	public void addLinSpeed(Vector3 v)
	{
		setLinSpeed(LinSpeed().plus(v));
	}
	
	@Override
	public void update(long delta)
	{			
		// Update the target object.
		Object().moveFor(LinSpeed().times(delta));
		Object().rotateFor(RotSpeed().times(delta));
		
		
		// Calculate the linear force.
		fTotal = calcLinDrag(LinSpeed());
		for(Force3D force : Forces())
		{
			fTotal = fTotal.plus(force.Vector());
		}
		
		// Update the linear velocity.
		float dMass = delta / Object().Mass();
		addLinSpeed(fTotal.times(dMass));
		
		
		// Calculate the angular force.
		fTotal = calcRotDrag(RotSpeed());
		for(Force3D force : Forces())
		{
			fTotal = fTotal.plus(force.Torque());
		}
		
		// Update the angular velocity.
		float dInert = delta / Object().Inertia();
		addAngSpeed(fTotal.times(dInert));
	}
}