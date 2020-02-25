package zeno.util.phys.integrate;

import java.util.HashSet;
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
 */
public class ITGAction<I extends Integrator> extends SteppedAction
{
	private static final long DEF_DELTA = 16;

	
	private Set<I> physics;
	private long tCurr, tAcc, delta;

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
	 * Returns the integrators of the {@code ITGAction}.
	 * 
	 * @return  a set of integrators
	 * 
	 * 
	 * @see Set
	 */
	public Set<I> Integrators()
	{
		return physics;
	}
	

	@Override
	public void onResume()
	{
		tCurr = System.currentTimeMillis();
	}
	
	@Override
	public void onStep()
	{
		for(Integrator ig : physics)
		{
			ig.onUpdate(delta);
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