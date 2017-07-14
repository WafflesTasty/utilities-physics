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
	 * Adds linear speed to the {@code Euler3D}.
	 * 
	 * @param v  a speed vector to add
	 * @see Vector3
	 */
	public void addLinSpeed(Vector3 v)
	{
		setLinSpeed(LinSpeed().plus(v));
	}
	
	/**
	 * Adds rotate speed to the {@code Euler3D}.
	 * 
	 * @param v  a speed vector to add
	 * @see Vector3
	 */
	public void addRotSpeed(Vector3 v)
	{
		setRotSpeed(RotSpeed().plus(v));
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
		
	
	protected void rotateFor(Vector3 v, float rad)
	{
		Object().rotateFor(v, rad);
	}
	
	protected void rotateFor(Vector3 v)
	{
		Object().rotateFor(v);
	}
	
	protected void moveFor(Vector3 v)
	{
		Object().moveFor(v);
	}
	
	@Override
	public void onUpdate(long dt)
	{			
		// Update the target object.
		moveFor(LinSpeed().times(dt));
		rotateFor(RotSpeed().times(dt));
		
		
		// Calculate the linear force.
		fTotal = calcLinDrag(LinSpeed());
		for(Force3D force : Forces())
		{
			fTotal = fTotal.plus(force.Vector());
		}
		
		// Update the linear velocity.
		float dMass = dt / Object().Mass();
		addLinSpeed(fTotal.times(dMass));
		
		
		// Calculate the angular force.
		fTotal = calcRotDrag(RotSpeed());
		for(Force3D force : Forces())
		{
			fTotal = fTotal.plus(force.Torque());
		}
		
		// Update the angular velocity.
		float dInert = dt / Object().Inertia();
		addRotSpeed(fTotal.times(dInert));
	}
}