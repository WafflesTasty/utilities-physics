package waffles.utils.phys.physical.angular;

import waffles.utils.geom.spatial.data.spin.Spin2D;
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
	 * @param a  a rotation angle
	 */
	public default void addRotSpeed(float a)
	{
		addRotSpeed(new Spin2D(a));
	}
	
	/**
	 * Changes the angular speed of the {@code AngularPhysical2D}.
	 * 
	 * @param a  a rotation angle
	 */
	public default void setRotSpeed(float a)
	{
		setRotSpeed(new Spin2D(a));
	}
	
	
	@Override
	public default Spin2D RotSpeed()
	{
		return (Spin2D) AngularPhysical.super.RotSpeed();
	}
}