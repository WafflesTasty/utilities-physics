package waffles.utils.phys;

/**
 * A {@code Strategy} updates individual drones in a {@code Swarm}.
 *
 * @author Waffles
 * @since 28 May 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see Dynamical
 */
@FunctionalInterface
public interface Strategy<D extends Dynamical>
{	
	/**
	 * An event raised when pulsing a drone in the {@code Strategy}.
	 * 
	 * @param src   a source drone
	 * @param time  a time interval
	 */
	public abstract void onPulse(D src, long time);
}