package waffles.utils.phys.drones.linear.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.data.unary.Propelled;

/**
 * A {@code Propellor} defines a {@code Propelled.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Propelled
 * @see Drive
 */
public class Propellor extends Drive implements Propelled.Mutable
{
	private Vector vAcc;
	
	/**
	 * Creates a new {@code Propellor}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Propellor(int dim)
	{
		super(dim);
		vAcc = Vectors.create(dim);
	}


	@Override
	public void setLinAccel(Vector a)
	{
		vAcc = a;
	}
	
	@Override
	public Vector LinAccel()
	{
		return vAcc;
	}
}