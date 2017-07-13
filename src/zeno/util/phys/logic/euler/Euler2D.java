package zeno.util.phys.logic.euler;

import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.phys.logic.Integrator2D;
import zeno.util.phys.state.force.Force2D;
import zeno.util.phys.state.objects.IPhysical2D;

/**
 * The {@code Euler2D} class integrates using the {@code semi-implicit Euler method}.
 * <br> To apply drag to the object, override the {@link #calcLinDrag(Vector2)} and
 * {@link #calcRotDrag(float)} methods to return a drag vector.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Semi-implicit_Euler_method">Wikipedia - Euler Method</a>
 * @see Integrator2D
 */
public class Euler2D extends Integrator2D
{	
	private float aTotal;
	private Vector2 fTotal;
	
	/**
	 * Creates a new {@code Euler2D}.
	 * 
	 * @param o  a target object
	 * @see IPhysical2D
	 */
	public Euler2D(IPhysical2D o)
	{
		super(o);
	}
	
	/**
	 * Adds linear speed to the {@code Euler2D}.
	 * 
	 * @param v  a speed vector to add
	 * @see Vector2
	 */
	public void addLinSpeed(Vector2 v)
	{
		setLinSpeed(LinSpeed().plus(v));
	}
	
	/**
	 * Calculates a drag vector caused by movement.
	 * 
	 * @param v  a linear speed vector
	 * @return  a drag force vector
	 * @see Vector2
	 */
	public Vector2 calcLinDrag(Vector2 v)
	{
		return new Vector2();
	}
	
	/**
	 * Calculates a drag value caused by rotation.
	 * 
	 * @param val  a rotate speed value
	 * @return  a drag force value
	 */
	public float calcRotDrag(float val)
	{
		return 0f;
	}
	
	/**
	 * Adds rotate speed to the {@code Euler2D}.
	 * 
	 * @param v  a speed vector to add
	 */
	public void addRotSpeed(float v)
	{
		setRotSpeed(RotSpeed() + v);
	}
	
	@Override
	public void update(long delta)
	{			
		// Update the target object.
		Object().moveFor(LinSpeed().times(delta));
		Object().rotateFor(RotSpeed() * delta);
		
		
		// Calculate the linear force.
		fTotal = calcLinDrag(LinSpeed());
		for(Force2D force : Forces())
		{
			fTotal = fTotal.plus(force.Vector());
		}
		
		// Update the linear velocity.
		float dMass = delta / Object().Mass();
		addLinSpeed(fTotal.times(dMass));
		
		
		// Calculate the angular force.
		aTotal = calcRotDrag(RotSpeed());
		for(Force2D force : Forces())
		{
			aTotal += force.Torque();
		}
		
		// Update the angular velocity.
		float dInert = delta / Object().Inertia();
		addRotSpeed(aTotal * dInert);
	}
}