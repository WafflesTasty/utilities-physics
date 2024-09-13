package waffles.utils.phys.swarms.limits;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.Strategy;
import waffles.utils.phys.drones.linear.types.Powerable;
import waffles.utils.phys.drones.linear.types.Powerable.Dynamics;

/**
 * A {@code LinearDrag} strategy adds a drag force to {@code Powerable} drones.
 *
 * @author Waffles
 * @since 04 Sep 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see Powerable
 * @see Strategy
 */
public interface LinearDrag<D extends Powerable> extends Strategy<D>
{
	/**
	 * Returns a drag scale for {@code LinearDrag}.
	 * The size of the force is set as the speed of
	 * the object times the drag scale.
	 * 
	 * @return  a drag coefficient
	 */
	public default float DragScale()
	{
		return 1f;
	}
	
	/**
	 * Returns a minimum required speed for {@code LinearDrag}.
	 * 
	 * @return  a minimum speed
	 */
	public default float MinDragSpeed()
	{
		return 0f;
	}


	@Override
	public default void onPulse(D src, long time)
	{
		float vMin = MinDragSpeed();
		Vector vLin = src.LinSpeed();
		float nSqr = vLin.normSqr();
			
		if(nSqr > vMin * vMin)
		{
			float cDrg = DragScale();
			Vector vFrc = vLin.times(-cDrg);
			Dynamics dyn = src.Dynamics();
			dyn.addLinForce(vFrc);
		}
	}
}