package zeno.util.phys.state;

import zeno.util.geom._deprecated.ITransformable;

/**
 * The {@code IPhysical} interface defines an object handled by physics engines.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see ITransformable
 */
public interface IPhysical extends ITransformable
{	
	/**
	 * Returns the inertia of the {@code IPhysical}.
	 * 
	 * @return  the object's inertia
	 */
	public abstract float Inertia();
	
	/**
	 * Returns the mass of the {@code IPhysical}.
	 * 
	 * @return  the object's mass
	 */
	public abstract float Mass();
}