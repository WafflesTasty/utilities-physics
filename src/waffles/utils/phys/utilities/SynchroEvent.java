package waffles.utils.phys.utilities;

/**
 * The {@code SynchroEvent} interface defines an {@link #onUpdate(long)} event.
 * This can be used to synchronize the internal state with the runtime.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 */
public interface SynchroEvent
{
	/**
	 * An event raised on updating the {@code SynchroEvent}.
	 * 
	 * @param time  a time interval (in ms)
	 */
	public default void onUpdate(long time)
	{
		// NOT APPLICABLE
	}
}