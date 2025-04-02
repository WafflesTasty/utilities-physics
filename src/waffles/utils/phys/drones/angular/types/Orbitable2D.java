package waffles.utils.phys.drones.angular.types;

import waffles.utils.geom.spatial.data.spin.Spin2D;

/**
 * An {@code Orbitable2D} can maintain its own angular force in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Twistable2D
 * @see Orbitable
 */
public interface Orbitable2D extends Orbitable, Twistable2D
{
	@Override
	public default Spin2D AngForce()
	{
		return (Spin2D) Orbitable.super.AngForce();
	}

	
	/**
	 * Orbits the {@code Orbitable2D} for an angular vector.
	 * 
	 * @param a  an angular spin
	 */
	public default void orbitFor(float a)
	{
		orbitFor(new Spin2D(a));
	}
	
	/**
	 * Orbits the {@code Powerable2D} to an angular vector.
	 * 
	 * @param a  an angular spin
	 */
	public default void orbitTo(float a)
	{
		orbitTo(new Spin2D(a));
	}
}