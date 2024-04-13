package waffles.utils.phys.physical.aligned;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.collidable.geometric.AxisAligned2D;

/**
 * An {@code AlignedPhysical2D} defines a two-dimensional axis-aligned object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AlignedPhysical
 * @see AxisAligned2D
 */
public interface AlignedPhysical2D extends AlignedPhysical, AxisAligned2D
{
	/**
	 * Adds a linear impulse to the {@code AlignedPhysical2D}.
	 * 
	 * @param x  a linear impulse x-coordinate
	 * @param y  a linear impulse y-coordinate
	 */
	public default void addLinImpulse(float x, float y)
	{
		addLinImpulse(new Vector2(x, y));
	}
	
	/**
	 * Changes the linear impulse of the {@code AlignedPhysical2D}.
	 * 
	 * @param x  a linear impulse x-coordinate
	 * @param y  a linear impulse y-coordinate
	 */
	public default void setLinImpulse(float x, float y)
	{
		setLinImpulse(new Vector2(x, y));
	}
	
	/**
	 * Adds a linear speed to the {@code AlignedPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void addLinSpeed(float x, float y)
	{
		addLinSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the linear speed of the {@code AlignedPhysical2D}.
	 * 
	 * @param x  a linear velocity x-coordinate
	 * @param y  a linear velocity y-coordinate
	 */
	public default void setLinSpeed(float x, float y)
	{
		setLinSpeed(new Vector2(x, y));
	}
	
	
	@Override
	public default Vector2 LinImpulse()
	{
		return (Vector2) AlignedPhysical.super.LinImpulse();
	}

	@Override
	public default Vector2 LinSpeed()
	{
		return (Vector2) AlignedPhysical.super.LinSpeed();
	}
}