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
public class Machine extends Propellor implements Powered.Mutable
{
	private float minv;
	private Vector vFrc;
	
	/**
	 * Creates a new {@code Machine}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Machine(int dim)
	{
		super(dim);
		vFrc = Vectors.create(dim);
		minv = 1f;
	}


	@Override
	public void setLinForce(Vector f)
	{
		vFrc = f;
	}
	
	@Override
	public void setMass(float m)
	{
		minv = 1f / m;
	}
	
	@Override
	public Vector LinForce()
	{
		return vFrc;
	}
	
	@Override
	public float InvMass()
	{
		return minv;
	}
}