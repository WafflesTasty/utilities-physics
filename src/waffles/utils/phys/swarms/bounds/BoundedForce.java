package waffles.utils.phys.swarms.bounds;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.types.Powerable;

/**
 * A {@code BoundedForce} strategy applies forces to drones when they move outside of bounds.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @param <D>  a drone type
 * @see BoundedStrategy
 * @see Powerable
 */
public interface BoundedForce<D extends Powerable> extends BoundedStrategy<D>
{
	/**
	 * Returns the force scale of the {@code BoundedForce}.
	 * 
	 * @return  a force scale
	 */
	public default float BoundedScale()
	{
		return 1f;
	}
	
	
	@Override
	public default void onBound(D src, Vector dst, long time)
	{
		Vector vFrc = dst.times(BoundedScale());
		src.powerFor(vFrc);
	}
}