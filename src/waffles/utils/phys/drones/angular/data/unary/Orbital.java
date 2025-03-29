package waffles.utils.phys.drones.angular.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;

/**
 * An {@code Orbital} object defines an angular force vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Twisted
 */
public interface Orbital extends Twisted
{
	/**
	 * A {@code Mutable Orbital} can change its own angular force.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Orbital
	 * @see Twisted
	 */
	public static interface Mutable extends Twisted.Mutable, Orbital
	{
		/**
		 * Adds an angular force to the {@code Orbital}.
		 * 
		 * @param f  an angular force
		 * 
		 * 
		 * @see Vector
		 */
		public default void addAngForce(Vector f)
		{
			setAngForce(AngForce().plus(f));
		}
		
		/**
		 * Changes the angular force of the {@code Orbital}.
		 * 
		 * @param f  an angular force
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setAngForce(Vector f);
		
		/**
		 * Changes the inertia of the {@code Orbital}.
		 * 
		 * @param i  an object inertia
		 */
		public abstract void setInertia(float i);
	}


	/**
	 * Returns the angular force of the {@code Orbital}.
	 * 
	 * @return  an angular force
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector AngForce();
	
	/**
	 * Returns the inverse inertia of the {@code Orbital}.
	 * 
	 * @return  an inverse inertia
	 */
	public default float InvInertia()
	{
		return 1f / Inertia();
	}
	
	/**
	 * Returns the inertia of the {@code Orbital}.
	 * 
	 * @return  an object inertia
	 */
	public default float Inertia()
	{
		return 1f / InvInertia();
	}
}
