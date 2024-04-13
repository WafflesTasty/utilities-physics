package waffles.utils.phys.physical.affine;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.collidable.geometric.AffineOriented2D;
import waffles.utils.phys.physical.aligned.AlignedPhysical2D;

/**
 * An {@code AffinePhysical2D} defines a two-dimensional affine-oriented object with general Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AlignedPhysical2D
 * @see AffineOriented2D
 * @see AffinePhysical
 */
public interface AffinePhysical2D extends AffinePhysical, AlignedPhysical2D, AffineOriented2D
{
	/**
	 * Adds an angular impulse to the {@code AffinePhysical2D}.
	 * 
	 * @param x  an angular impulse x-coordinate
	 * @param y  an angular impulse y-coordinate
	 */
	public default void addRotImpulse(float x, float y)
	{
		addRotImpulse(new Vector2(x, y));
	}
	
	/**
	 * Changes the angular impulse of the {@code AffinePhysical2D}.
	 * 
	 * @param x  an angular impulse x-coordinate
	 * @param y  an angular impulse y-coordinate
	 */
	public default void setRotImpulse(float x, float y)
	{
		setRotImpulse(new Vector2(x, y));
	}
	
	/**
	 * Adds an angular speed to the {@code AffinePhysical2D}.
	 * 
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 */
	public default void addRotSpeed(float x, float y)
	{
		addRotSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the angular speed of the {@code AffinePhysical2D}.
	 * 
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 */
	public default void setRotSpeed(float x, float y)
	{
		setRotSpeed(new Vector2(x, y));
	}
	
	
	@Override
	public default Vector2 RotImpulse()
	{
		return (Vector2) AffinePhysical.super.RotImpulse();
	}

	@Override
	public default Vector2 RotSpeed()
	{
		return (Vector2) AffinePhysical.super.RotSpeed();
	}
}