package waffles.utils.phys.drones.scalar.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * A {@code Squeezed} object defines a scalar force vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Wedged
 */
public interface Squeezed extends Wedged
{
	/**
	 * A {@code Mutable Squeezed} can change its own scalar force.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Squeezed
	 * @see Wedged
	 */
	public static interface Mutable extends Wedged.Mutable, Squeezed
	{
		/**
		 * Adds a scalar force to the {@code Squeezed}.
		 * 
		 * @param f  a scalar force
		 * 
		 * 
		 * @see Vector
		 */
		public default void addPinForce(Vector f)
		{
			setPinForce(PinForce().plus(f));
		}
		
		/**
		 * Changes the scalar force of the {@code Squeezed}.
		 * 
		 * @param f  a scalar force
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setPinForce(Vector f);
		
		/**
		 * Changes the mass of the {@code Squeezed}.
		 * 
		 * @param m  an object mass
		 */
		public abstract void setMass(float m);
	}


	/**
	 * Returns the scalar force of the {@code Squeezed}.
	 * 
	 * @return  a scalar force
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector PinForce();
	
	/**
	 * Returns the inverse mass of the {@code Squeezed}.
	 * 
	 * @return  an inverse mass
	 */
	public default float InvMass()
	{
		return 1f / Mass();
	}
	
	/**
	 * Returns the mass of the {@code Squeezed}.
	 * 
	 * @return  an object mass
	 */
	public default float Mass()
	{
		return 1f / InvMass();
	}
}
