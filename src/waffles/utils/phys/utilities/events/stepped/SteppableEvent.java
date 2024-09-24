package waffles.utils.phys.utilities.events.stepped;

import waffles.utils.phys.utilities.Steppable;
import waffles.utils.phys.utilities.events.PulseEvent;
import waffles.utils.tools.patterns.semantics.Idleable;

/**
 * A {@code SteppableEvent} is a pulse event which can be started, stepped and paused.
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
public interface SteppableEvent extends PulseEvent, Idleable, Steppable
{
	/**
	 * Changes the idle state of the {@code SteppedEvent}.
	 * 
	 * @param isIdle  an idle state
	 */
	public abstract void setIdle(boolean isIdle);
	
	
	@Override
	public default void onUpdate(long time)
	{       
		if(!isIdle())
		{
			PulseEvent.super.onUpdate(time);
		}
	}

	
	@Override
	public default void pause()
	{
		setIdle(true);
	}
	
	@Override
	public default void step()
	{
		setIdle(false);
		onUpdate(BeatTime());
		setIdle(true);
	}

	@Override
	public default void run()
	{
		setIdle(false);
	}
}