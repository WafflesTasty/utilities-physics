package waffles.utils.phys.drones.linear.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.data.unary.Powered;

/**
 * A {@code Machine} defines a {@code Powered.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Propellor
 * @see Powered
 */
public class Tractor extends Propellor implements Powered.Mutable
{
	private float mInv;
	private Vector vFrc;
	
	/**
	 * Creates a new {@code Machine}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Tractor(int dim)
	{
		super(dim);
		vFrc = Vectors.create(dim);
		mInv = 1f;
	}


	@Override
	public void setLinForce(Vector f)
	{
		vFrc = f;
	}
	
	@Override
	public void setMass(float m)
	{
		mInv = 1f / m;
	}
	
	@Override
	public Vector LinForce()
	{
		return vFrc;
	}
	
	@Override
	public float InvMass()
	{
		return mInv;
	}
}