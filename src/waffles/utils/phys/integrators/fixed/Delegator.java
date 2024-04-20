package waffles.utils.phys.integrators.fixed;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.integrators.Integrator;

/**
 * A {@code Delegator} defines an {@code Integrator} that forwards
 * its methods to a delegate object.
 *
 * @author Waffles
 * @since 20 Apr 2024
 * @version 1.1
 * 
 * 
 * @param <O>  an object type
 * @see Integrator
 */
public interface Delegator<O> extends Integrator<O>
{
	/**
	 * Returns the physics {@code Integrator}.
	 * 
	 * @return  a time integrator
	 * 
	 * 
	 * @see Integrator
	 */
	public abstract Integrator<O> Integrator();
	
	
	@Override
	public default float elasticity(O src, O tgt)
	{
		return Integrator().elasticity(src, tgt);
	}
	
	@Override
	public default void bounce(O src, O tgt, Vector p, float c)
	{
		Integrator().bounce(src, tgt, p, c);
	}

	@Override
	public default void bounce(O src, Vector p, float c)
	{
		Integrator().bounce(src, p, c);
	}	
	
	@Override
	public default void update(O src, long time)
	{
		Integrator().update(src, time);
	}
}