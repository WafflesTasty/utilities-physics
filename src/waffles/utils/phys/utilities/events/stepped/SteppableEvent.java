package waffles.utils.phys.utilities.events.stepped;

import waffles.utils.phys.utilities.Steppable;
import waffles.utils.phys.utilities.events.pulsed.PulsableEvent;

/**
 * A {@code SteppableEvent} is a pulse event which can be started, stepped and paused.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see PulsableEvent
 * @see Steppable
 */
public interface SteppableEvent extends Steppable, PulsableEvent
{
	/**
	 * A {@code Stride} defines the inner mechanism of a {@code SteppableEvent}.
	 *
	 * @author Waffles
	 * @since 24 Sep 2024
	 * @version 1.1
	 */
	public static class Stride extends Pulse
	{
		private boolean isIdle;
		
		/**
		 * Creates a new {@code Stride}.
		 * 
		 * @param e  a steppable event
		 * 
		 * 
		 * @see SteppableEvent
		 */
		public Stride(SteppableEvent e)
		{
			super(e);
			isIdle = true;
		}
		
		/**
		 * Changes the idle state of the {@code Stride}.
		 * 
		 * @param isIdle  an idle state
		 */
		public void setIdle(boolean isIdle)
		{
			this.isIdle = isIdle;
		}
		
		/**
		 * Returns the idle state of the {@code Stride}.
		 * 
		 * @return  an idle state
		 */
		public boolean isIdle()
		{
			return isIdle;
		}
	}
	
	
	@Override
	public default void onUpdate(long time)
	{       
		if(!Pulse().isIdle())
		{
			PulsableEvent.super.onUpdate(time);
		}
	}
	
	@Override
	public abstract Stride Pulse();
	
	
	@Override
	public default void pause()
	{
		Pulse().setIdle(true);
	}
	
	@Override
	public default void step()
	{
		Pulse().setIdle(true);
		onPulse(BeatTime());
	}

	@Override
	public default void run()
	{
		Pulse().setIdle(false);
	}
}