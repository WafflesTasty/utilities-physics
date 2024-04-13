package waffles.utils.phys.dynamics;

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
	private float inertia;
	private Vector vAng, vImp;
	
	/**
	 * Creates a new {@code AngularDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public AngularDynamics(int dim)
	{
		vAng = Vectors.create(dim);
		vImp = Vectors.create(dim);
	}
	
	
	@Override
	public void setRotImpulse(Vector v)
	{
		vImp = v;
	}
	
	@Override
	public void setRotSpeed(Vector v)
	{
		vAng = v;
	}

	@Override
	public void setInertia(float i)
	{
		inertia = i;
	}

	@Override
	public Vector RotImpulse()
	{
		return vImp;
	}
	
	@Override
	public Vector RotSpeed()
	{
		return vAng;
	}

	@Override
	public float Inertia()
	{
		return inertia;
	}	
}