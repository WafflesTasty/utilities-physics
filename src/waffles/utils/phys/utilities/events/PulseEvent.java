package waffles.utils.phys.utilities.events;

/**
 * A {@code PulseEvent} defines a {@code SynchroEvent} that updates in constant pulses.
 * The {@code beat} value defines the time in milliseconds for each pulse.
 *
 * @author Waffles
 * @since 20 Apr 2024
 * @version 1.1
 *
 * 
 * @see SynchroEvent
 */
public abstract class PulseEvent implements SynchroEvent
{
	private long delta, beat;

	/**
	 * Creates a new {@code PulseEvent}.
	 * 
	 * @param beat  a beat time
	 */
	public PulseEvent(long beat)
	{
		this.beat = beat;
	}
	
	/**
	 * An event raised on pulsing the {@code PulseEvent}.
	 * 
	 * @param beat  a beat time
	 */
	public abstract void onPulse(long beat);

	/**
	 * Returns the beat of the {@code PulseEvent}.
	 * 
	 * @return  a beat time
	 */
	public long Beat()
	{
		return beat;
	}
	
	
	@Override
	public void onUpdate(long time)
	{
		delta += time;
		while(delta >= beat)
		{
			delta -= beat;
			onPulse(beat);
		}
	}
}