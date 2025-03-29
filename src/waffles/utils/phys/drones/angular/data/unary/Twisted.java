package waffles.utils.phys.drones.angular.data.unary;

import waffles.utils.geom.spatial.data.spin.Spin;

/**
 * A {@code Twisted} object defines an angular acceleration spin.
 *
 * @author Waffles
 * @since 26 Jul 2024
 * @version 1.0
 * 
 * 
 * @see Screwed
 */
public interface Twisted extends Screwed
{
	/**
	 * A {@code Mutable Twisted} can change its own angular acceleration.
	 *
	 * @author Waffles
	 * @since 16 Oct 2023
	 * @version 1.0
	 * 
	 * 
	 * @see Twisted
	 * @see Screwed
	 */
	public static interface Mutable extends Screwed.Mutable, Twisted
	{
		/**
		 * Changes the angular acceleration of the {@code Twisted}.
		 * 
		 * @param a  an angular acceleration
		 * 
		 * 
		 * @see Spin
		 */
		public abstract void setAngAccel(Spin a);
	}


	/**
	 * Returns the angular acceleration of the {@code Twisted}.
	 * 
	 * @return  an angular acceleration
	 * 
	 * 
	 * @see Spin
	 */
	public abstract Spin AngAccel();
}
