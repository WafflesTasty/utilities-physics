package zeno.util.phys;

/**
 * The {@code Integrator} interface defines a physics integrator.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 */
@FunctionalInterface
public interface Integrator
{
	/**
	 * Event raised on updating the {@code Integrator}.
	 * 
	 * @param time  a time interval in ms
	 */
	public abstract void onUpdate(long time);
}