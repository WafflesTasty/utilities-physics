package waffles.utils.phys.drones.linear.data.unary;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * A {@code Driven} object defines a linear speed vector.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Immutable
 */
public interface Driven extends Immutable, Dimensional
{
	/**
	 * A {@code Mutable Driven} can change its own linear speed.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Driven
	 */
	public static interface Mutable extends Immutable.Mutable, Driven
	{		
		/**
		 * Changes the linear speed of the {@code Driven}.
		 * 
		 * @param v  a linear speed
		 * 
		 * 
		 * @see Vector
		 */
		public abstract void setLinSpeed(Vector v);
	}
	

	/**
	 * Returns the linear speed of the {@code Driven}.
	 * 
	 * @return  a linear speed
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinSpeed();
	
	@Override
	public default int Dimension()
	{
		return LinSpeed().Size();
	}
}
