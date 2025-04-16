package waffles.utils.phys.drones.scalar.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * A {@code Wedged} object defines a scalar acceleration vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Pinched
 */
public interface Wedged extends Pinched
{
	/**
	 * A {@code Mutable Wedged} can change its own scalar acceleration.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Wedged
	 * @see Pinched
	 */
	public static interface Mutable extends Pinched.Mutable, Wedged
	{
		/**
		 * Changes the scalar acceleration of the {@code Wedged}.
		 * 
		 * @param a  a scalar acceleration
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setPinAccel(Vector a);
	}


	/**
	 * Returns the scalar acceleration of the {@code Wedged}.
	 * 
	 * @return  a scalar acceleration
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector PinAccel();
}
