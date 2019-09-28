package zeno.util.phys.entities;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.phys.IDynamics;

/**
 * The {@code Dynamics2D} class defines dynamics for a two-dimensional object.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see IDynamics
 */
public class Dynamics2D implements IDynamics
{
	private float inert, mass;
	private Vector3 vLin, vRot;
	private IPhysical2D target;
	
	/**
	 * Creates a new {@code Dynamics2D}.
	 * 
	 * @param tgt  a target object
	 * 
	 * 
	 * @see IPhysical2D
	 */
	public Dynamics2D(IPhysical2D tgt)
	{
		target = tgt;
	}

	/**
	 * Changes the inertia of the {@code Dynamics2D}.
	 * 
	 * @param inert  a new inertia
	 */
	public void setInertia(float inert)
	{
		this.inert = inert;
	}
	
	/**
	 * Changes the mass of the {@code Dynamics2D}.
	 * 
	 * @param mass  a new mass
	 */
	public void setMass(float mass)
	{
		this.mass = mass;
	}
	
	
	@Override
	public IPhysical2D Delegate()
	{
		return target;
	}
	
	@Override
	public void setLinSpeed(Vector v)
	{
		vLin = (Vector3) v;
	}

	@Override
	public void setRotSpeed(Vector v)
	{
		vRot = (Vector3) v;
	}

	@Override
	public Vector3 LinSpeed()
	{
		return vLin;
	}

	@Override
	public Vector3 RotSpeed()
	{
		return vRot;
	}

		
	@Override
	public float Inertia()
	{
		return inert;
	}

	@Override
	public float Mass()
	{
		return mass;
	}
}