package waffles.utils.phys.swarms;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.Impactable;

/**
 * An {@code ImpactStrategy} impacts pairs of drones in a {@code PairedStrategy}.
 *
 * @author Waffles
 * @since 11 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see PairedStrategy
 * @see Impactable
 */
public interface ImpactStrategy<D extends Impactable> extends PairedStrategy<D>
{
	/**
	 * An event raised when impacting two drones in the {@code ImpactStrategy}.
	 * 
	 * @param src   a source drone
	 * @param tgt   a target drone
	 * @param pnt   a penetration vector
	 * @param time  a time interval
	 * 
	 * 
	 * @see Vector
	 */
	public default void onImpact(D src, D tgt, Vector pnt, long time)
	{
		// NOT APPLICABLE
	}
}