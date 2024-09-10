package waffles.utils.phys.swarms.bounds;

import waffles.utils.algebra.elements.linear.matrix.Matrices;
import waffles.utils.algebra.elements.linear.matrix.Matrix;
import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.types.Drivable;

/**
 * A {@code BoundedImpulse} strategy applies impulses to drones when they move outside of bounds.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @param <D>  a drone type
 * @see BoundedStrategy
 * @see Drivable
 */
public interface BoundedImpulse<D extends Drivable> extends BoundedStrategy<D>
{
	/**
	 * Returns the elasticity of the {@code BoundedImpulse}.
	 * 
	 * @return  an elasticity coefficient
	 */
	public default float Elasticity()
	{
		return 1f;
	}
	
	
	@Override
	public default void onBound(D src, Vector dst, long time)
	{
		Vector vSpd = src.LinSpeed();
		if(vSpd.dot(dst) <= 0)
		{
			float c = Elasticity();
			Matrix m = Matrices.reflection(dst);
			
			vSpd = m.times(vSpd).times(c);
			src.speedTo(vSpd);
		}
	}
}