package waffles.utils.phys.drones.linear.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * A {@code Propelled} object defines a linear acceleration vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Driven
 */
public interface Propelled extends Driven
{
	/**
	 * A {@code Mutable Propelled} can change its own linear acceleration.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Propelled
	 * @see Driven
	 */
	public static interface Mutable extends Driven.Mutable, Propelled
	{
		/**
		 * Changes the linear acceleration of the {@code Propelled}.
		 * 
		 * @param a  a linear acceleration
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinAccel(Vector a);
	}


	/**
	 * Returns the linear acceleration of the {@code Propelled}.
	 * 
	 * @return  a linear acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinAccel();
}
