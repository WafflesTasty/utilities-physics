package waffles.utils.phys.drones.angular.data.unary;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.tools.patterns.semantics.Immutable;

/**
 * A {@code Screwed} object defines an angular speed spin.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Dimensional
 * @see Immutable
 */
public interface Screwed extends Immutable, Dimensional
{
	/**
	 * A {@code Mutable Screwed} can change its own angular speed.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Screwed
	 */
	public static interface Mutable extends Immutable.Mutable, Screwed
	{		
		/**
		 * Changes the angular speed of the {@code Screwed}.
		 * 
		 * @param s  an angular speed
		 * 
		 * 
		 * @see Spin
		 */
		public abstract void setAngSpeed(Spin s);
	}
	

	/**
	 * Returns the angular speed of the {@code Screwed}.
	 * 
	 * @return  an angular speed
	 * 
	 * 
	 * @see Spin
	 */
	public abstract Spin AngSpeed();
	
	@Override
	public default int Dimension()
	{
		return AngSpeed().Dimension();
	}
}
