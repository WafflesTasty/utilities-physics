package waffles.utils.phys.integrators;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * An {@code Integrator} computes the state of objects colliding in a {@code Physics} simulation.
 *
 * @author Waffles
 * @since 14 Apr 2024
 * @version 1.1
 *
 *
 * @param <O>  an object type
 */
public interface Integrator<O>
{	
	/**
	 * Bounces two objects off eachother in the {@code Integrator}.
	 * 
	 * @param src  a source object
	 * @param tgt  a target object
	 * @param p    a penetration vector
	 * @param c    an elasticity value
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void bounce(O src, O tgt, Vector p, float c);
	
	/**
	 * Bounces an object off an immovable in the {@code Integrator}.
	 * 
	 * @param src  a source object
	 * @param p    a penetration vector
	 * @param c    an elasticity value
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void bounce(O src, Vector p, float c);
	
	/**
	 * Returns an elasticity coefficient in the {@code Integrator}.
	 * 
	 * @param src  a source object
	 * @param tgt  a target object
	 * @return  an elasticity coefficient
	 */
	public abstract float elasticity(O src, O tgt);
	
	/**
	 * Updates an object with the {@code Integrator}.
	 * 
	 * @param src   a source object
	 * @param time  a time interval (in ms)
	 */
	public abstract void update(O src, long time);
}