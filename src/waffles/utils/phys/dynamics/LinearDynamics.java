package waffles.utils.phys.dynamics;

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
	private Vector vLin, vImp;
	
	/**
	 * Creates a new {@code LinearDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public LinearDynamics(int dim)
	{
		vLin = Vectors.create(dim);
		vImp = Vectors.create(dim);
	}
	
	
	@Override
	public void setLinImpulse(Vector v)
	{
		vImp = v;
	}
	
	@Override
	public void setLinSpeed(Vector v)
	{
		vLin = v;
	}

	@Override
	public void setMass(float m)
	{
		mass = m;
	}

	@Override
	public Vector LinImpulse()
	{
		return vImp;
	}
	
	@Override
	public Vector LinSpeed()
	{
		return vLin;
	}

	@Override
	public float Mass()
	{
		return mass;
	}	
}