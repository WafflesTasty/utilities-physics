package waffles.utils.phys.dynamics.linear;

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
		 * Adds to the {@code LinearDynamical} acceleration.
		 * 
		 * @param v  a linear acceleration
		 * 
		 * 
		 * @see Vector
		 */
		public default void addLinAccel(Vector v)
		{
			setLinAccel(LinAccel().plus(v));
		}
		
		/**
		 * Adds to the {@code LinearDynamical} force.
		 * 
		 * @param v  a linear force
		 * 
		 * 
		 * @see Vector
		 */
		public default void addLinForce(Vector v)
		{
			setLinForce(LinForce().plus(v));
		}
		
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
		 * Changes the maximum {@code LinearDynamical} speed.
		 * 
		 * @param v  a maximum speed
		 */
		public abstract void setMaxLinSpeed(float v);
		
		/**
		 * Changes the {@code LinearDynamical} acceleration.
		 * 
		 * @param v  a linear acceleration
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinAccel(Vector v);
		
		/**
		 * Changes the {@code LinearDynamical} force.
		 * 
		 * @param v  a linear force
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinForce(Vector v);
		
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
		 * Changes the {@code LinearDynamical} mass.
		 * 
		 * @param m  an object mass
		 */
		public abstract void setMass(float m);
	}
	
	
	/**
	 * Returns the maximum {@code LinearDynamical} speed.
	 * 
	 * @return  a maximum speed
	 */
	public abstract float MaxLinSpeed();
	
	/**
	 * Returns the {@code LinearDynamical} acceleration.
	 * 
	 * @return  a linear acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinAccel();
	
	/**
	 * Returns the {@code LinearDynamical} force.
	 * 
	 * @return  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinForce();
		
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