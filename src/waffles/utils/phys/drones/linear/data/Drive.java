package waffles.utils.phys.drones.linear.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.data.unary.Driven;

/**
 * A {@code Drive} defines a {@code Driven.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Driven
 */
public class Drive implements Driven.Mutable
{
	private Vector vSpd;
	
	/**
	 * Creates a new {@code Drive}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Drive(int dim)
	{
		vSpd = Vectors.create(dim);
	}


	@Override
	public void setLinSpeed(Vector v)
	{
		vSpd = v;
	}
	
	@Override
	public Vector LinSpeed()
	{
		return vSpd;
	}
}