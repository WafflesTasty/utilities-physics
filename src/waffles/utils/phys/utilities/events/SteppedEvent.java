package waffles.utils.phys.utilities.events;

/**
 * A {@code SteppedEvent} is a pulse event which can be started, stepped and paused.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.1
 * 
 * 
 * @see PulseEvent
 */
public abstract class SteppedEvent extends PulseEvent
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
		onPulse(Beat());
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
			super.onUpdate(time);
		}
	}
}