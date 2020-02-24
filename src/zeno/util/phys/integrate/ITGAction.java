package zeno.util.phys.integrate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import zeno.util.phys.Integrator;
import zeno.util.tools.helper.tasks.SteppedAction;

/**
 * The {@code ITGAction} class executes physics integrators
 * at a predictable rate in time. Every step accumulates
 * the time passed and executes physics accordingly
 * in fixed time steps.
 *
 * @author Zeno
 * @since Jul 14, 2017
 * @version 1.0
 * 
 * 
 * @param <I>  an integrator type
 * @see SteppedAction
 * @see Integrator
 * @see Iterable
 */
public class ITGAction<I extends Integrator> extends SteppedAction implements Iterable<I>
{
	private static final long DEF_DELTA = 16;

	
	private long tCurr, tAcc, delta;
	private Set<I> physics;

	/**
	 * Creates a new {@code ITGAction}.
	 * 
	 * @param dt  an update delta
	 */
	public ITGAction(long dt)
	{
		physics = new HashSet<>();
		delta = dt;
	}
	
	/**
	 * Creates a new {@code ITGAction}.
	 */
	public ITGAction()
	{
		this(DEF_DELTA);
	}
	
	
	/**
	 * Adds an integrator to the {@code ITGAction}.
	 * 
	 * @param integrator  an integrator to add
	 */
	public void add(I integrator)
	{
		physics.add(integrator);
	}
	
	/**
	 * Removes an integrator from the {@code ITGAction}.
	 * 
	 * @param integrator  an integrator to remove
	 * 
	 * 
	 * @see Integrator
	 */
	public void remove(I integrator)
	{
		physics.remove(integrator);
	}
	
	/**
	 * Changes the delta of the {@code ITGAction}.
	 * 
	 * @param delta  a new delta
	 */
	public void setDelta(long delta)
	{
		this.delta = delta;
	}

	
	@Override
	public Iterator<I> iterator()
	{
		return physics.iterator();
	}
	
	
	@Override
	public void onResume()
	{
		tCurr = System.currentTimeMillis();
	}
	
	@Override
	public void onStep()
	{
		Iterator<I> iter = physics.iterator();
		while(iter.hasNext())
		{
			Integrator ig = iter.next();
			
			ig.onUpdate(delta);
			if(ig.isFinished())
			{
				iter.remove();
			}
		}
	}
	
	@Override
	public void onStop()
	{
		tAcc = 0;
	}
	
	@Override
	public void onRun()
	{
		long tNew = System.currentTimeMillis();
		long tFrame = tNew - tCurr;
		tCurr = tNew;
		

        tAcc += tFrame;
        while(tAcc >= delta)
        {
            tAcc -= delta;
            onStep();
        }
	}
}