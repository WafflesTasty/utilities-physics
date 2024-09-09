package waffles.utils.phys;

import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.utilities.events.SynchroEvent;
import waffles.utils.sets.queues.Queue;
import waffles.utils.sets.queues.delegate.JFIFOQueue;

/**
 * A {@code Swarm} updates a set of {@code Dynamical} drones as a {@code SynchroEvent}.
 *
 * @author Waffles
 * @since 28 May 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see SynchroEvent
 * @see Dynamical
 * @see Strategy
 */
public abstract class Swarm<D extends Dynamical> implements Strategy<D>, SynchroEvent
{	
	private Queue<D> queue;

	/**
	 * Creates a new {@code Swarm}.
	 */
	public Swarm()
	{
		queue = new JFIFOQueue<>();
	}
	
	
	/**
	 * Returns the manifold of the {@code Swarm}.
	 * 
	 * @return  a swarm manifold
	 * 
	 * 
	 * @see Manifold
	 */
	public abstract Manifold<D> Manifold();
	
	/**
	 * Returns the strategy of the {@code Swarm}.
	 * 
	 * @return  a swarm strategy
	 * 
	 * 
	 * @see Strategy
	 */
	public abstract Strategy<D> Strategy();
	
		
	@Override
	public void onPulse(D src, long time)
	{
		queue.push(src);
		if(Strategy() != null)
		{
			Strategy().onPulse(src, time);
		}
		
		SynchroEvent dyn = src.Dynamics();
		dyn.onUpdate(time);
	}
	
	@Override
	public void onUpdate(long time)
	{		
		for(D drn : Manifold())
		{
			onPulse(drn, time);
		}
		
		Manifold().clear();
		while(!queue.isEmpty())
		{
			D drn = queue.pop();
			Manifold().add(drn);
		}
	}
}