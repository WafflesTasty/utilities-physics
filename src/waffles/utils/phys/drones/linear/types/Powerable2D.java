package waffles.utils.phys.drones.linear.types;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;

/**
 * A {@code Powerable2D} can maintain its own linear force in two-dimensional space.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @see Propellable2D
 * @see Powerable
 */
public interface Powerable2D extends Powerable, Propellable2D
{
	@Override
	public default Vector2 LinForce()
	{
		return (Vector2) Powerable.super.LinForce();
	}

	
	/**
	 * Powers the {@code Powerable2D} for a linear vector.
	 * 
	 * @param x  a linear force x
	 * @param y  a linear force y
	 */
	public default void powerFor(float x, float y)
	{
		powerFor(new Vector2(x, y));
	}
	
	/**
	 * Powers the {@code Powerable2D} to a linear vector.
	 * 
	 * @param x  a linear force x
	 * @param y  a linear force y
	 */
	public default void powerTo(float x, float y)
	{
		powerTo(new Vector2(x, y));
	}
}