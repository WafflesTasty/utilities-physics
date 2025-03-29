package waffles.utils.phys.drones.angular.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

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
	public default Vector2 AngForce()
	{
		return (Vector2) Orbitable.super.AngForce();
	}

	
	/**
	 * Orbits the {@code Orbitable2D} for an angular vector.
	 * 
	 * @param x  an angular force x
	 * @param y  an angular force y
	 */
	public default void orbitFor(float x, float y)
	{
		orbitFor(new Vector2(x, y));
	}
	
	/**
	 * Orbits the {@code Powerable2D} to an angular vector.
	 * 
	 * @param x  an angular force x
	 * @param y  an angular force y
	 */
	public default void orbitTo(float x, float y)
	{
		orbitTo(new Vector2(x, y));
	}
}