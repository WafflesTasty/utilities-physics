package waffles.utils.phys.drones.angular.data;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.drones.angular.data.unary.Screwed;

/**
 * A {@code Screw} defines a {@code Screwed.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.0
 * 
 * 
 * @see Screwed
 */
public class Screw implements Screwed.Mutable
{
	private Spin vSpd;
	
	/**
	 * Creates a new {@code Screw}.
	 * 
	 * @param dim  a vector dimension
	 */
	public Screw(int dim)
	{
		vSpd = Spin.create(dim);
	}


	@Override
	public void setAngSpeed(Spin v)
	{
		vSpd = v;
	}
	
	@Override
	public Spin AngSpeed()
	{
		return vSpd;
	}
}