package waffles.utils.phys.utilities.events.pulsed;

import waffles.utils.phys.utilities.events.SynchroEvent;

/**
 * A {@code PulsableEvent} defines a {@code SynchroEvent} that updates in constant pulses.
 * The {@code beat} value defines the time in milliseconds for each pulse.
 *
 * @author Waffles
 * @since 20 Apr 2024
 * @version 1.0
 *
 * 
 * @see SynchroEvent
 */
public interface PulsableEvent extends SynchroEvent
{
	/**
	 * A {@code Pulse} defines the inner mechanism of a {@code PulseEvent}.
	 * On each call to {@link #onUpdate(long)}, the {@code Pulse} will perform
	 * a number of calls to {@link PulsableEvent#onPulse(long)} depending on
	 * the number of beat times that have passed.
	 *
	 * @author Waffles
	 * @since 24 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see SynchroEvent
	 */
	public static class Pulse implements SynchroEvent
	{
		private long delta;
		private PulsableEvent evt;
		
		
		/**
		 * Creates a new {@code Pulse}.
		 * 
		 * @param e  a pulse event
		 * 
		 * 
		 * @see PulsableEvent
		 */
		public Pulse(PulsableEvent e)
		{
			evt = e;
		}

		
		@Override
		public void onUpdate(long time)
		{
			long beat = evt.BeatTime();
			
			
			delta += time;
			while(delta >= beat)
			{
				evt.onPulse(beat);
				delta -= beat;
			}
		}
	}

	
	/**
	 * Returns the beat time of the {@code PulseEvent}.
	 * 
	 * @return  a beat time
	 */
	public abstract long BeatTime();
	
	/**
	 * An event raised on pulsing the {@code PulseEvent}.
	 * 
	 * @param beat  a beat time
	 */
	public abstract void onPulse(long beat);
	
	/**
	 * Returns the pulse of the {@code PulseEvent}.
	 * 
	 * @return  a pulse
	 * 
	 * 
	 * @see Pulse
	 */
	public abstract Pulse Pulse();
	
	
	@Override
	public default void onUpdate(long time)
	{
		Pulse().onUpdate(time);
	}
}