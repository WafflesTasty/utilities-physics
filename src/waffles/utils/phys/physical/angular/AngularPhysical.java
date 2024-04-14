package waffles.utils.phys.physical.angular;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collidable;
import waffles.utils.geom.spatial.types.Rotatable;
import waffles.utils.phys.dynamics.angular.AngularDynamical;

/**
 * An {@code AngularPhysical} defines a collidable object with angular Newtonian physics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamical
 * @see Collidable
 * @see Rotatable
 */
public interface AngularPhysical extends AngularDynamical.Mutable, Collidable, Rotatable
{
	/**
	 * Returns the dynamics of the {@code AngularPhysical}.
	 * 
	 * @return  an angular dynamics
	 * 
	 * 
	 * @see AngularDynamical
	 */
	public abstract AngularDynamical Dynamics();

	
	@Override
	public default void setRotSpeed(Vector v)
	{
		AngularDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setRotSpeed(v);
		}
	}
	
	@Override
	public default void setInertia(float i)
	{
		AngularDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setInertia(i);
		}
	}


	@Override
	public default Vector RotSpeed()
	{
		return Dynamics().RotSpeed();
	}
	
	@Override
	public default float Inertia()
	{
		return Dynamics().Inertia();
	}
}