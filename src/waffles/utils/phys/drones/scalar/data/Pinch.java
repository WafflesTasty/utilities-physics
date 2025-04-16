package waffles.utils.phys.drones.scalar.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.scalar.data.unary.Pinched;

/**
 * A {@code Pinch} defines a {@code Pinched.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Pinched
 */
public class Pinch implements Pinched.Mutable
{
	private Vector vSpd;
	
	/**
	 * Creates a new {@code Pinch}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Pinch(int dim)
	{
		vSpd = Vectors.create(dim);
	}


	@Override
	public void setPinSpeed(Vector v)
	{
		vSpd = v;
	}
	
	@Override
	public Vector PinSpeed()
	{
		return vSpd;
	}
}