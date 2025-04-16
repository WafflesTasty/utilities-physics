package waffles.utils.phys.drones.scalar.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * A {@code Pinched} object defines a scalar speed vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Dimensional
 * @see Immutable
 */
public interface Pinched extends Immutable, Dimensional
{
	/**
	 * A {@code Mutable Pinched} can change its own scalar speed.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Pinched
	 */
	public static interface Mutable extends Immutable.Mutable, Pinched
	{		
		/**
		 * Changes the scalar speed of the {@code Driven}.
		 * 
		 * @param v  a scalar speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setPinSpeed(Vector v);
	}
	

	/**
	 * Returns the scalar speed of the {@code Driven}.
	 * 
	 * @return  a scalar speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector PinSpeed();
	
	@Override
	public default int Dimension()
	{
		return PinSpeed().Size();
	}
}
