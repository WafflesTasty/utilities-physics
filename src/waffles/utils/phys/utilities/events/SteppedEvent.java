package waffles.utils.phys.utilities.events;

/**
 * The {@code SteppedTask} class defines a task that can be paused and stepped through.
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
	public boolean isRunning()
	{
		return isRunning;
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
		onPulse();
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
		if(isRunning())
		{
			super.onUpdate(time);
		}
	}
}