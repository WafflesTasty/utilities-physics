package zeno.util.phys;

import zeno.util.geom.collidables.IShapeable;
import zeno.util.geom.collidables.affine.Point;

/**
 * The {@code IPhysical} interface defines an object with Newtonian physics properties.
 * 
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see IShapeable
 */
public interface IPhysical extends IShapeable
{	
	/**
	 * Returns the mass point of the {@code IPhysical}.
	 * 
	 * @return  a mass point
	 * 
	 * 
	 * @see Point
	 */
	public default Point MassPoint()
	{
		return new Point(Origin(), Mass());
	}
	
	/**
	 * Returns the inertia of the {@code IPhysical}.
	 * 
	 * @return  an object inertia
	 */
	public abstract float Inertia();
	
	/**
	 * Returns the mass of the {@code IPhysical}.
	 * 
	 * @return  an object mass
	 */
	public abstract float Mass();
}