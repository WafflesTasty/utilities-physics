package zeno.util.phys.entities;

import zeno.util.algebra.linear.vector.fixed.Vector3;
import zeno.util.geom.collidables.IShapeable3D;
import zeno.util.phys.IPhysical;

/**
 * The {@code IPhysical3D} interface defines a three-dimensional object with Newtonian physics properties.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see IShapeable3D
 * @see IPhysical
 */
public interface IPhysical3D extends IPhysical, IShapeable3D
{
	@Override
	public abstract Dynamics3D Dynamics();

	
	@Override
	public default Vector3 LinSpeed()
	{
		return (Vector3) IPhysical.super.LinSpeed();
	}
	
	@Override
	public default Vector3 RotSpeed()
	{
		return (Vector3) IPhysical.super.RotSpeed();
	}
}