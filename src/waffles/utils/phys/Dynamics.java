package waffles.utils.phys;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.dynamics.AngularDynamics;
import waffles.utils.phys.dynamics.LinearDynamics;

/**
 * The {@code Dynamics} class defines a linear and angular speed, inertia and mass.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Dynamical
 */
public class Dynamics implements Dynamical.Mutable
{
	private LinearDynamics dLin;
	private AngularDynamics dRot;
	
	/**
	 * Creates a new {@code Dynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Dynamics(int dim)
	{
		dLin = new LinearDynamics(dim);
		dRot = new AngularDynamics(dim);
	}
	
		
	@Override
	public void setLinImpulse(Vector v)
	{
		dLin.setLinImpulse(v);
	}
	
	@Override
	public void setRotImpulse(Vector v)
	{
		dRot.setRotImpulse(v);
	}
	
	@Override
	public void setLinSpeed(Vector v)
	{
		dLin.setLinSpeed(v);
	}
	
	@Override
	public void setRotSpeed(Vector v)
	{
		dRot.setRotSpeed(v);
	}
	
	@Override
	public void setInertia(float i)
	{
		dRot.setInertia(i);
	}
	
	@Override
	public void setMass(float m)
	{
		dLin.setMass(m);
	}

	
	@Override
	public Vector LinImpulse()
	{
		return dLin.LinImpulse();
	}
	
	@Override
	public Vector RotImpulse()
	{
		return dRot.RotImpulse();
	}
	
	@Override
	public Vector LinSpeed()
	{
		return dLin.LinSpeed();
	}
	
	@Override
	public Vector RotSpeed()
	{
		return dRot.RotSpeed();
	}
	
	@Override
	public float Inertia()
	{
		return dRot.Inertia();
	}
	
	@Override
	public float Mass()
	{
		return dLin.Mass();
	}
}