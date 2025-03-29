package waffles.utils.phys.drones.angular.data;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.unary.Twisted;

/**
 * A {@code Gear} defines a {@code Twisted.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Twisted
 * @see Screw
 */
public class Gear extends Screw implements Twisted.Mutable
{
	private Spin vAcc;
	
	/**
	 * Creates a new {@code Gear}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Gear(int dim)
	{
		super(dim);
		vAcc = Spin.create(dim);
	}


	@Override
	public void setAngAccel(Spin a)
	{
		vAcc = a;
	}
	
	@Override
	public Spin AngAccel()
	{
		return vAcc;
	}
}