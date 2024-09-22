package waffles.utils.phys.utilities.events;

import waffles.utils.phys.utilities.Steppable;
import waffles.utils.tools.patterns.semantics.Idleable;

/**
 * A {@code SteppedEvent} is a pulse event which can be started, stepped and paused.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see PulseEvent
 * @see Steppable
 * @see Idleable
 */
public abstract class SteppedEvent extends PulseEvent implements Idleable, Steppable
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
	
	
	@Override
	public void onUpdate(long time)
	{       
		if(!isIdle())
		{
			super.onUpdate(time);
		}
	}
	
	@Override
	public boolean isIdle()
	{
		return !isRunning;
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