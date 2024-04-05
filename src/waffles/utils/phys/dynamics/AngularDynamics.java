package waffles.utils.phys.dynamics;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * An {@code AngularDynamics} object defines an angular speed and inertia.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Immutable
 */
public interface AngularDynamics extends Immutable
{
	/**
	 * A {@code Mutable AngularDynamics} can change its own speed and inertia.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see AngularDynamics
	 */
	public static interface Mutable extends Immutable.Mutable, AngularDynamics
	{
		/**
		 * Adds to the {@code AngularDynamics} speed.
		 * 
		 * @param v  an angular speed
		 * 
		 * 
		 * @see Vector
		 */
		public default void addRotSpeed(Vector v)
		{
			setRotSpeed(RotSpeed().plus(v));
		}
			
		/**
		 * Changes the {@code AngularDynamics} speed.
		 * 
		 * @param v  an angular speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setRotSpeed(Vector v);
		
		/**
		 * Changes the {@code AngularDynamics} inertia.
		 * 
		 * @param i  an object inertia
		 */
		public abstract void setInertia(float i);
	}
	
	
	/**
	 * Returns the {@code AngularDynamics} speed.
	 * 
	 * @return  an angular speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector RotSpeed();
	
	/**
	 * Returns the {@code AngularDynamics} inertia.
	 * 
	 * @return  an object inertia
	 */
	public abstract float Inertia();
}