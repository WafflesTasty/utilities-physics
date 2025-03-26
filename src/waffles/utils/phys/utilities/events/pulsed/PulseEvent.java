package waffles.utils.phys.utilities.events.pulsed;

import waffles.utils.phys.utilities.events.SynchroEvent;

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
public class PulseEvent implements PulsableEvent
{
	private long beat;
	private Pulse pulse;
	private SynchroEvent evt;
	
	/**
	 * Creates a new {@code PulseEvent}.
	 * 
	 * @param b  a beat time
	 * @param e  a synchro event
	 * 
	 * 
	 * @see SynchroEvent
	 */
	public PulseEvent(long b, SynchroEvent e)
	{
		pulse = new Pulse(this);
		beat = b; evt = e;
	}
	
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
	public void onPulse(long beat)
	{
		if(evt != null)
		{
			evt.onUpdate(beat);
		}
	}

	@Override
	public Pulse Pulse()
	{
		return pulse;
	}
}