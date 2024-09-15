package waffles.utils.phys.swarms.isolator;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.swarms.PairedStrategy;

/**
 * A {@code LinearIsolation} strategy applies forces to drones to drive them apart.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @param <D>  a drone type
 * @see LinearIsolated
 * @see PairedStrategy
 */
public interface LinearIsolation<D extends LinearIsolated> extends PairedStrategy<D>
{
	@Override
	public default void onHit(D src, D tgt, Vector pnt, long time)
	{
		Vector v1 = src.LinSpeed();
		Vector v2 = tgt.LinSpeed();
		
		Vector i1 = pnt.times(+1f).minus(v2);
		Vector i2 = pnt.times(-1f).minus(v1);
		
		src.addIsolator(i1);
		tgt.addIsolator(i2);
	}
}