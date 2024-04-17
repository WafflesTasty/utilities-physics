package waffles.utils.phys.dynamics.angular;

import waffles.utils.geom.spatial.data.spin.Spin;
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
		 * @param s  a spin speed
		 * 
		 * 
		 * @see Spin
		 */
		public default void addRotSpeed(Spin s)
		{
			setRotSpeed(s.compose(RotSpeed()));
		}
			
		/**
		 * Changes the {@code AngularDynamical} speed.
		 * 
		 * @param s  a spin speed
		 * 
		 * 
		 * @see Spin
		 */
		public abstract void setRotSpeed(Spin s);
				
		/**
		 * Changes the {@code AngularDynamical} inertia.
		 * 
		 * @param i  an object inertia
		 */
		public abstract void setInertia(float i);
	}
	
		
	/**
	 * Returns the {@code AngularDynamical} speed.
	 * 
	 * @return  a spin speed
	 * 
	 * 
	 * @see Spin
	 */
	public abstract Spin RotSpeed();
		
	/**
	 * Returns the {@code AngularDynamical} inertia.
	 * 
	 * @return  an object inertia
	 */
	public abstract float Inertia();
}