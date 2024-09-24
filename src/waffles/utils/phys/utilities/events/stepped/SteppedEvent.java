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
	private Stride stride;
	
	/**
	 * Creates a new {@code SteppedEvent}.
	 * 
	 * @param b  a beat time
	 */
	public SteppedEvent(long b)
	{
		stride = new Stride(this);
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
	public long BeatTime()
	{
		return beat;
	}

	@Override
	public Stride Pulse()
	{
		return stride;
	}
}