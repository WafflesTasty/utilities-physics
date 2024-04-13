package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.spatial.types.Movable2D;

/**
 * An {@code LinearPhysical2D} defines a two-dimensional axis-aligned object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see LinearPhysical
 * @see Movable2D
 */
public interface LinearPhysical2D extends LinearPhysical, Movable2D
{
	/**
	 * Adds a linear speed to the {@code LinearPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void addLinSpeed(float x, float y)
	{
		addLinSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the linear speed of the {@code LinearPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void setLinSpeed(float x, float y)
	{
		setLinSpeed(new Vector2(x, y));
	}
	

	@Override
	public default Vector2 LinSpeed()
	{
		return (Vector2) LinearPhysical.super.LinSpeed();
	}
}