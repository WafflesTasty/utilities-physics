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
	 * Event raised on booting the {@code Integrator}.
	 */
	public default void onBoot()
	{
		// NOT APPLICABLE
	}
	
	/**
	 * Event raised on disposing the {@code Integrator}.
	 */
	public default void onDispose()
	{
		// NOT APPLICABLE
	}
	
	/**
	 * Event raised on updating the {@code Integrator}.
	 * 
	 * @param dt  a delta time in ms
	 */
	public abstract void onUpdate(long dt);
	
	/**
	 * Checks the state of the {@code Integrator}.
	 * 
	 * @return  {@code true} if the task is finished
	 */
	public default boolean isFinished()
	{
		return false;
	}
}