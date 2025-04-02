package waffles.utils.phys.swarms.limits;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.phys.Strategy;
import waffles.utils.phys.drones.angular.types.Orbitable;
import waffles.utils.phys.drones.angular.types.Orbitable.Dynamics;

/**
 * A {@code RotateDrag} strategy adds a drag force to {@code Orbitable} drones.
 *
 * @author Waffles
 * @since 04 Sep 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see Orbitable
 * @see Strategy
 */
public interface RotateDrag<D extends Orbitable> extends Strategy<D>
{
	/**
	 * Returns a drag scale for {@code RotateDrag}.
	 * The size of the force is set as the speed of
	 * the object times the drag scale.
	 * 
	 * @return  a drag coefficient
	 */
	public default float RotDragScale()
	{
		return 1f;
	}
	
	/**
	 * Returns a minimum required speed for {@code RotateDrag}.
	 * 
	 * @return  a minimum speed
	 */
	public default float MinRotDragSpeed()
	{
		return 0f;
	}


	@Override
	public default void onPulse(D src, long time)
	{
		float vMin = MinRotDragSpeed();
		Spin sRot = src.AngSpeed();
		float nSqr = sRot.norm();
			
		if(nSqr > vMin * vMin)
		{
			float cDrg = RotDragScale();
			Spin sFrc = sRot.times(-cDrg);
			Dynamics dyn = src.Dynamics();
			dyn.addAngForce(sFrc);
		}
	}
}