package waffles.utils.phys.utilities.events;

import waffles.utils.phys.utilities.Steppable;

/**
 * A {@code SteppedEvent} is a pulse event which can be started, stepped and paused.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.1
 * 
 * 
 * @see PulseEvent
 * @see Steppable
 */
public abstract class SteppedEvent extends PulseEvent implements Steppable
{
	private boolean isRunning;
	
	/**
	 * Creates a new {@code SteppedEvent}.
	 * 
	 * @param beat  a beat time
	 */
	public SteppedEvent(long beat)
	{
		super(beat);
	}

	/**
	 * Checks the state of the {@code SteppedEvent}.
	 * 
	 * @return  {@code true} if running
	 */
	public boolean isIdle()
	{
		return !isRunning;
	}
	
	
	@Override
	public void onUpdate(long time)
	{       
		if(!isIdle())
		{
			super.onUpdate(time);
		}
	}
	

	@Override
	public void pause()
	{
		isRunning = false;
	}
	
	@Override
	public void step()
	{
		isRunning = false;
		onPulse(Beat());
	}

	@Override
	public void run()
	{
		isRunning = true;
	}
}