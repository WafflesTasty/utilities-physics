package waffles.utils.phys.drones.linear.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * A {@code Powered} object defines a linear force vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Propelled
 */
public interface Powered extends Propelled
{
	/**
	 * A {@code Mutable Powered} can change its own linear force.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Propelled
	 * @see Powered
	 */
	public static interface Mutable extends Propelled.Mutable, Powered
	{
		/**
		 * Adds a linear force to the {@code Powered}.
		 * 
		 * @param f  a linear force
		 * 
		 * 
		 * @see Vector
		 */
		public default void addLinForce(Vector f)
		{
			setLinForce(LinForce().plus(f));
		}
		
		/**
		 * Changes the linear force of the {@code Powered}.
		 * 
		 * @param f  a linear force
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinForce(Vector f);
		
		/**
		 * Changes the mass of the {@code Powered}.
		 * 
		 * @param m  an object mass
		 */
		public abstract void setMass(float m);
	}


	/**
	 * Returns the linear force of the {@code Powered}.
	 * 
	 * @return  a linear force
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinForce();
	
	/**
	 * Returns the mass of the {@code Powered}.
	 * 
	 * @return  an object mass
	 */
	public abstract float Mass();
}
