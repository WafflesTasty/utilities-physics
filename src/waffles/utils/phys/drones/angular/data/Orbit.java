package waffles.utils.phys.drones.angular.data;

import waffles.utils.geom.spatial.data.spin.Spin;
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
	private Spin sFrc;
	
	/**
	 * Creates a new {@code Orbit}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Orbit(int dim)
	{
		super(dim);
		sFrc = Spin.create(dim);
		iInv = 1f;
	}

	
	@Override
	public Spin AngForce()
	{
		return sFrc;
	}

	@Override
	public void setAngForce(Spin s)
	{
		sFrc = s;
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