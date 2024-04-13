package waffles.utils.phys.dynamics;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * A {@code LinearDynamical} object defines a linear speed and mass.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Immutable
 */
public interface LinearDynamical extends Immutable
{
	/**
	 * A {@code LinearDynamical.Mutable} can change its own speed and mass.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see LinearDynamical
	 */
	public static interface Mutable extends Immutable.Mutable, LinearDynamical
	{
		/**
		 * Adds to the {@code LinearDynamical} speed.
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
		 * Adds to the {@code LinearDynamical} impulse.
		 * 
		 * @param v  a linear impulse
		 * 
		 * 
		 * @see Vector
		 */
		public default void addLinImpulse(Vector v)
		{
			setLinImpulse(LinImpulse().plus(v));
		}
		
			
		/**
		 * Changes the {@code LinearDynamical} speed.
		 * 
		 * @param v  a linear speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinSpeed(Vector v);
		
		/**
		 * Changes the {@code LinearDynamical} impulse.
		 * 
		 * @param v  a linear impulse
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinImpulse(Vector v);
		
		/**
		 * Changes the {@code LinearDynamical} mass.
		 * 
		 * @param m  an object mass
		 */
		public abstract void setMass(float m);
	}
	
	
	/**
	 * Returns the {@code LinearDynamical} impulse.
	 * 
	 * @return  a linear impulse
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinImpulse();
		
	/**
	 * Returns the {@code LinearDynamical} speed.
	 * 
	 * @return  a linear speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinSpeed();
		
	/**
	 * Returns the {@code LinearDynamical} mass.
	 * 
	 * @return  an object mass
	 */
	public abstract float Mass();
}