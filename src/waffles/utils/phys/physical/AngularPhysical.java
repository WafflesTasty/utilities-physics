package waffles.utils.phys.physical;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.dynamics.AngularDynamical;

/**
 * An {@code AngularPhysical} object can handle angular kinetics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamical
 */
public interface AngularPhysical extends AngularDynamical.Mutable
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
	public default void setRotImpulse(Vector v)
	{
		AngularDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setRotImpulse(v);
		}
	}

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
	public default Vector RotImpulse()
	{
		return Dynamics().RotImpulse();
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