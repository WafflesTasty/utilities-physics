package waffles.utils.phys.drones.angular.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.angular.data.unary.Orbital;

/**
 * An {@code Orbit} defines a {@code Orbital.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Orbital
 * @see Gear
 */
public class Orbit extends Gear implements Orbital.Mutable
{
	private float iInv;
	private Vector vFrc;
	
	/**
	 * Creates a new {@code Orbit}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Orbit(int dim)
	{
		super(dim);
		vFrc = Vectors.create(dim);
		iInv = 1f;
	}

	
	@Override
	public Vector AngForce()
	{
		return vFrc;
	}

	@Override
	public void setAngForce(Vector f)
	{
		vFrc = f;
	}
	
	@Override
	public void setInertia(float i)
	{
		iInv = 1f / i;
	}
	
	@Override
	public float InvInertia()
	{
		return iInv;
	}
}