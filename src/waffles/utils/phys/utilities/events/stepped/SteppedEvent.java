package waffles.utils.phys.utilities.events.stepped;

/**
 * A {@code SteppedEvent} implements a basic {@code SteppableEvent}.
 * 
 * @author Waffles
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see SteppableEvent
 */
public abstract class SteppedEvent implements SteppableEvent
{
	private long beat;
	private Pulse pulse;
	private boolean isIdle;
	
	/**
	 * Creates a new {@code SteppedEvent}.
	 * 
	 * @param b  a beat time
	 */
	public SteppedEvent(long b)
	{
		pulse = new Pulse(this);
		isIdle = true;
		beat = b;
	}
	
	/**
	 * Creates a new {@code SteppedEvent}.
	 * By default, the event runs at 30 FPS.
	 */
	public SteppedEvent()
	{
		this(33);
	}

	
	@Override
	public void setIdle(boolean isIdle)
	{
		this.isIdle = isIdle;
	}

	@Override
	public boolean isIdle()
	{
		return isIdle;
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