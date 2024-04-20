package waffles.utils.phys.utilities.events;

/**
 * A {@code SteppedEvent} can be started, stepped and paused.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.1
 * 
 * 
 * @see SynchroEvent
 */
public abstract class SteppedEvent implements SynchroEvent
{
	private boolean isRunning;

	/**
	 * An event raised when the {@code SteppedEvent} steps.
	 */
	public abstract void onStep();
	
	/**
	 * Checks the state of the {@code SteppedEvent}.
	 * 
	 * @return  {@code true} if running
	 */
	public boolean isIdle()
	{
		return !isRunning;
	}

	/**
	 * Pauses the {@code SteppedEvent}.
	 */
	public void pause()
	{
		isRunning = false;
	}
	
	/**
	 * Steps the {@code SteppedEvent}.
	 */
	public void step()
	{
		isRunning = false;
		onStep();
	}
	
	/**
	 * Runs the {@code SteppedEvent}.
	 */
	public void run()
	{
		isRunning = true;
	}
	
	
	@Override
	public void onUpdate(long time)
	{       
		if(!isIdle())
		{
			onStep();
		}
	}
}