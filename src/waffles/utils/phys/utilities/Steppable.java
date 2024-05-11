package waffles.utils.phys.utilities;

/**
 * A {@code Steppable} object can run, pause and step its execution.
 *
 * @author Waffles
 * @since 11 May 2024
 * @version 1.1
 */
public interface Steppable
{
	/**
	 * Pauses the {@code Steppable}.
	 */
	public abstract void pause();
	
	/**
	 * Steps the {@code Steppable}.
	 */
	public abstract void step();
	
	/**
	 * Runs the {@code Steppable}.
	 */
	public abstract void run();
}