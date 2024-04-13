package waffles.utils.phys.dynamics.angular;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;

/**
 * An {@code AngularDynamics} defines a basic {@code AngularDynamical.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamical
 */
public class AngularDynamics implements AngularDynamical.Mutable
{
	private Vector vel;
	private float inertia;
	
	/**
	 * Creates a new {@code AngularDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public AngularDynamics(int dim)
	{
		vel = Vectors.create(dim);
	}
	
		
	@Override
	public void setRotSpeed(Vector v)
	{
		vel = v;
	}

	@Override
	public void setInertia(float i)
	{
		inertia = i;
	}

	@Override
	public Vector RotSpeed()
	{
		return vel;
	}

	@Override
	public float Inertia()
	{
		return inertia;
	}	
}