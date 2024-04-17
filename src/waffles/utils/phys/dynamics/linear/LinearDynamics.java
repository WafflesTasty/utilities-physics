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
	private Vector vFrc, vSpd, vAcc;
	
	/**
	 * Creates a new {@code LinearDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public LinearDynamics(int dim)
	{
		vAcc = Vectors.create(dim);
		vFrc = Vectors.create(dim);
		vSpd = Vectors.create(dim);
	}
	
	
	@Override
	public void setLinAccel(Vector v)
	{
		vAcc = v;
	}
	
	@Override
	public void setLinForce(Vector v)
	{
		vFrc = v;
	}
	
	@Override
	public void setLinSpeed(Vector v)
	{
		vSpd = v;
	}

	@Override
	public void setMass(float m)
	{
		mass = m;
	}
	
	@Override
	public Vector LinAccel()
	{
		return vAcc;
	}

	@Override
	public Vector LinForce()
	{
		return vFrc;
	}
	
	@Override
	public Vector LinSpeed()
	{
		return vSpd;
	}

	@Override
	public float Mass()
	{
		return mass;
	}	
}