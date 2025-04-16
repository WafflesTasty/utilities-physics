package waffles.utils.phys.drones.scalar.data;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.scalar.data.unary.Squeezed;

/**
 * A {@code Squeeze} defines a {@code Squeezed.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Squeezed
 * @see Wedge
 */
public class Squeeze extends Wedge implements Squeezed.Mutable
{
	private float mInv;
	private Vector vFrc;
	
	/**
	 * Creates a new {@code Squeeze}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Squeeze(int dim)
	{
		super(dim);
		vFrc = Vectors.create(dim);
		mInv = 1f;
	}


	@Override
	public void setPinForce(Vector f)
	{
		vFrc = f;
	}
	
	@Override
	public void setMass(float m)
	{
		mInv = 1f / m;
	}
	
	@Override
	public Vector PinForce()
	{
		return vFrc;
	}
	
	@Override
	public float InvMass()
	{
		return mInv;
	}
}