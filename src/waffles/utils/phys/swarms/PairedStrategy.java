package waffles.utils.phys.swarms;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.Strategy;

/**
 * A {@code PairedStrategy} updates pairs of drones in a {@code Strategy}.
 *
 * @author Waffles
 * @since 11 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see Dynamical
 * @see Strategy
 */
public interface PairedStrategy<D extends Dynamical> extends Strategy<D>
{
	/**
	 * An event raised when hitting two drones in the {@code PairedStrategy}.
	 * 
	 * @param src   a source drone
	 * @param tgt   a target drone
	 * @param pnt   a penetration vector
	 * @param time  a time interval
	 */
	public default void onHit(D src, D tgt, Vector pnt, long time)
	{
		// NOT APPLICABLE
	}
	
	/**
	 * An event raised when pulsing two drones in the {@code PairedStrategy}.
	 * 
	 * @param src   a source drone
	 * @param tgt   a target drone
	 * @param time  a time interval
	 */
	public default void onPulse(D src, D tgt, long time)
	{
		// NOT APPLICABLE
	}		
}