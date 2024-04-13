package waffles.utils.phys.dynamics.linear;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;

/**
 * A {@code LinearDynamics} defines a basic {@code LinearDynamical.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 * 
 * 
 * @see LinearDynamical
 */
public class LinearDynamics implements LinearDynamical.Mutable
{
	private float mass;
	private Vector vel;
	
	/**
	 * Creates a new {@code LinearDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public LinearDynamics(int dim)
	{
		vel = Vectors.create(dim);
	}
	
	
	@Override
	public void setLinSpeed(Vector v)
	{
		vel = v;
	}

	@Override
	public void setMass(float m)
	{
		mass = m;
	}

	@Override
	public Vector LinSpeed()
	{
		return vel;
	}

	@Override
	public float Mass()
	{
		return mass;
	}	
}