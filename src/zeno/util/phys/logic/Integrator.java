package zeno.util.phys.logic;

/**
 * The {@code Integrator} interface defines a physics integrator.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 */
public interface Integrator
{
	/**
	 * Updates the state of the {@code Integrator}.
	 * 
	 * @param dt  a delta time
	 */
	public abstract void onUpdate(long dt);
}