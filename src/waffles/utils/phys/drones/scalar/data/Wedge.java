package waffles.utils.phys.drones.scalar.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.scalar.data.unary.Wedged;

/**
 * A {@code Wedge} defines a {@code Wedged.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Wedged
 * @see Pinch
 */
public class Wedge extends Pinch implements Wedged.Mutable
{
	private Vector vAcc;
	
	/**
	 * Creates a new {@code Wedge}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Wedge(int dim)
	{
		super(dim);
		vAcc = Vectors.create(dim);
	}


	@Override
	public void setPinAccel(Vector a)
	{
		vAcc = a;
	}
	
	@Override
	public Vector PinAccel()
	{
		return vAcc;
	}
}