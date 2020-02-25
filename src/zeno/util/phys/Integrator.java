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
	 * @param dt  a delta time in ms
	 */
	public abstract void onUpdate(long dt);
}