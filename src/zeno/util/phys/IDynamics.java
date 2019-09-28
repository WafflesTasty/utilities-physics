package zeno.util.phys;

import zeno.util.algebra.linear.vector.Vector;
import zeno.util.geom.collidables.affine.Point;
import zeno.util.tools.patterns.Decorator;

/**
 * The {@code IDynamics} interface defines properties of an {@code IPhysical}.
 *
 * @author Zeno
 * @since Sep 28, 2019
 * @version 1.0
 * 
 * 
 * @see Decorator
 * @see IPhysical
 */
public interface IDynamics extends Decorator<IPhysical>
{
	/**
	 * Returns the mass point of the {@code IDynamics}.
	 * 
	 * @return  a mass point
	 * 
	 * 
	 * @see Point
	 */
	public default Point MassPoint()
	{
		return new Point(Delegate().Origin(), Mass());
	}
	
	
	/**
	 * Adds linear speed to the {@code IDynamics}.
	 * 
	 * @param v  a speed vector to add
	 * 
	 * 
	 * @see Vector
	 */
	public default void addLinSpeed(Vector v)
	{
		setLinSpeed(LinSpeed().plus(v));
	}
	
	/**
	 * Adds rotate speed to the {@code IDynamics}.
	 * 
	 * @param v  a speed vector to add
	 * 
	 * 
	 * @see Vector
	 */
	public default void addRotSpeed(Vector v)
	{
		setRotSpeed(RotSpeed().plus(v));
	}
	
	/**
	 * Changes linear speed of the {@code IDynamics}.
	 * 
	 * @param v  a speed vector to set
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void setLinSpeed(Vector v);
	
	/**
	 * Changes rotate speed of the {@code IDynamics}.
	 * 
	 * @param v  a speed vector to set
	 * 
	 * 
	 * @see Vector
	 */
	public abstract void setRotSpeed(Vector v);
	
	
	/**
	 * Returns the linear speed of the {@code IDynamics}.
	 * 
	 * @return  a linear speed vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector LinSpeed();
	
	/**
	 * Returns the rotate speed of the {@code IDynamics}.
	 * 
	 * @return  a rotate speed vector
	 * 
	 * 
	 * @see Vector
	 */
	public abstract Vector RotSpeed();

	/**
	 * Returns the inertia of the {@code IDynamics}.
	 * 
	 * @return  an inertia value
	 */
	public abstract float Inertia();
	
	/**
	 * Returns the mass of the {@code IDynamics}.
	 * 
	 * @return  a mass value
	 */
	public abstract float Mass();
}