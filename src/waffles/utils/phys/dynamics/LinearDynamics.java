package waffles.utils.phys.dynamics;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * A {@code LinearDynamics} object defines a linear speed and mass.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Immutable
 */
public interface LinearDynamics extends Immutable
{
	/**
	 * A {@code Mutable LinearDynamics} can change its own speed and mass.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see LinearDynamics
	 */
	public static interface Mutable extends Immutable.Mutable, LinearDynamics
	{
		/**
		 * Adds to the {@code LinearDynamics} speed.
		 * 
		 * @param v  a linear speed
		 * 
		 * 
		 * @see Vector
		 */
		public default void addLinSpeed(Vector v)
		{
			setLinSpeed(LinSpeed().plus(v));
		}
			
		/**
		 * Changes the {@code LinearDynamics} speed.
		 * 
		 * @param v  a linear speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinSpeed(Vector v);
		
		/**
		 * Changes the {@code LinearDynamics} mass.
		 * 
		 * @param m  an object mass
		 */
		public abstract void setMass(float m);
	}
	
	
	/**
	 * Returns the {@code LinearDynamics} speed.
	 * 
	 * @return  a linear speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinSpeed();
	
	/**
	 * Returns the {@code LinearDynamics} mass.
	 * 
	 * @return  an object mass
	 */
	public abstract float Mass();
}