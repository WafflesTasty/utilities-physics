package waffles.utils.phys.physical.angular;

import waffles.utils.algebra.elements.linear.vector.fixed.Vector2;
import waffles.utils.geom.spatial.types.Rotatable2D;

/**
 * An {@code AngularPhysical2D} defines a two-dimensional rotatable object with angular Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AngularPhysical
 * @see Rotatable2D
 */
public interface AngularPhysical2D extends AngularPhysical, Rotatable2D
{
	/**
	 * Adds an angular speed to the {@code AngularPhysical2D}.
	 * 
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 */
	public default void addRotSpeed(float x, float y)
	{
		addRotSpeed(new Vector2(x, y));
	}
	
	/**
	 * Changes the angular speed of the {@code AngularPhysical2D}.
	 * 
	 * @param x  an angular velocity x-coordinate
	 * @param y  an angular velocity y-coordinate
	 */
	public default void setRotSpeed(float x, float y)
	{
		setRotSpeed(new Vector2(x, y));
	}
	
	
	@Override
	public default Vector2 RotSpeed()
	{
		return (Vector2) AngularPhysical.super.RotSpeed();
	}
}