package waffles.utils.phys.dynamics;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * An {@code AngularDynamical} object defines an angular speed and inertia.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Immutable
 */
public interface AngularDynamical extends Immutable
{
	/**
	 * A {@code AngularDynamical.Mutable} can change its own speed and inertia.
	 *
	 * @author Waffles
	 * @since 05 Apr 2024
	 * @version 1.1
	 * 
	 * 
	 * @see AngularDynamical
	 */
	public static interface Mutable extends Immutable.Mutable, AngularDynamical
	{
		/**
		 * Adds to the {@code AngularDynamical} speed.
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
		 * Adds to the {@code AngularDynamical} impulse.
		 * 
		 * @param v  an angular impulse
		 * 
		 * 
		 * @see Vector
		 */
		public default void addRotImpulse(Vector v)
		{
			setRotImpulse(RotImpulse().plus(v));
		}
		
			
		/**
		 * Changes the {@code AngularDynamical} speed.
		 * 
		 * @param v  an angular speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setRotSpeed(Vector v);
		
		/**
		 * Changes the {@code AngularDynamical} impulse.
		 * 
		 * @param v  an angular impulse
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setRotImpulse(Vector v);
		
		/**
		 * Changes the {@code AngularDynamical} inertia.
		 * 
		 * @param i  an object inertia
		 */
		public abstract void setInertia(float i);
	}
	
	
	/**
	 * Returns the {@code AngularDynamical} impulse.
	 * 
	 * @return  an angular impulse
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector RotImpulse();
		
	/**
	 * Returns the {@code AngularDynamical} speed.
	 * 
	 * @return  an angular speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector RotSpeed();
		
	/**
	 * Returns the {@code AngularDynamical} inertia.
	 * 
	 * @return  an object inertia
	 */
	public abstract float Inertia();
}