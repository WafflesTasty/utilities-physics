package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

/**
 * A {@code Propellable2D} can maintain its own linear acceleration in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Propellable
 * @see Drivable2D
 */
public interface Propellable2D extends Propellable, Drivable2D
{
	@Override
	public default Vector2 LinAccel()
	{
		return (Vector2) Propellable.super.LinAccel();
	}

	
	/**
	 * Propels the {@code Propellable2D} for a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void propelFor(float x, float y)
	{
		propelFor(new Vector2(x, y));
	}
	
	/**
	 * Propels the {@code Propellable2D} to a linear vector.
	 * 
	 * @param x  a linear speed x
	 * @param y  a linear speed y
	 */
	public default void propelTo(float x, float y)
	{
		propelTo(new Vector2(x, y));
	}
}