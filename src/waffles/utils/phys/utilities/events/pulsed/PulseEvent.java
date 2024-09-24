package waffles.utils.phys.utilities.events.pulsed;

/**
 * A {@code PulseEvent} implements a basic {@code PulsableEvent}.
 *
 * @author Waffles
 * @since 20 Apr 2024
 * @version 1.0
 *
 * 
 * @see PulsableEvent
 */
public abstract class PulseEvent implements PulsableEvent
{
	private long beat;
	private Pulse pulse;
	
	/**
	 * Creates a new {@code PulseEvent}.
	 * 
	 * @param b  a beat time
	 */
	public PulseEvent(long b)
	{
		pulse = new Pulse(this);
		beat = b;
	}


	@Override
	public long BeatTime()
	{
		return beat;
	}

	@Override
	public Pulse Pulse()
	{
		return pulse;
	}
}