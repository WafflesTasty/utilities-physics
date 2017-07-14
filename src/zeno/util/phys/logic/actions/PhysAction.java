package zeno.util.phys.logic.actions;

import java.util.HashSet;
import java.util.Set;

import zeno.util.phys.logic.Integrator;
import zeno.util.tools.generic.manipulators.Executable;

/**
 * The {@code PhysAction} class executes physics integrators
 * at a predictable rate in time. Every step accumulates
 * the time passed and executes physics accordingly
 * in fixed time steps.
 *
 * @author Zeno
 * @since Jul 14, 2017
 * @version 1.0
 * 
 * @see Executable
 */
public class PhysAction implements Executable
{
	private static final long DEF_DELTA = 16;
	
	private enum State
	{
		STARTING,
		RUNNING;
	}
	

	private State state;
	private long tCurr, tAcc, delta;
	private Set<Integrator> physics;

	/**
	 * Creates a new {@code PhysAction}.
	 */
	public PhysAction()
	{
		delta = DEF_DELTA;
		state = State.STARTING;
		physics = new HashSet<>();
	}
	
	/**
	 * Adds an integrator to the {@code PhysAction}.
	 * 
	 * @param ig  an integrator to add
	 * @see Integrator
	 */
	public void add(Integrator ig)
	{
		physics.add(ig);
	}
	
	/**
	 * Removes an integrator from the {@code PhysAction}.
	 * 
	 * @param ig  an integrator to remove
	 * @see Integrator
	 */
	public void remove(Integrator ig)
	{
		physics.remove(ig);
	}
	
	/**
	 * Changes the delta of the {@code PhysAction}.
	 * 
	 * @param delta  a new delta
	 */
	public void setDelta(long delta)
	{
		this.delta = delta;
	}
	
	
	@Override
	public void execute()
	{
		long tNew = System.currentTimeMillis();
        long tFrame = tNew - tCurr;
        tCurr = tNew;
        
        if(state == State.STARTING)
		{
			state = State.RUNNING;
			return;
		}
        
        tAcc += tFrame;
        while(tAcc >= delta)
        {
        	for(Integrator ig : physics)
        	{
        		ig.onUpdate(delta);
        	}

            tAcc -= delta;
        }
	}
}