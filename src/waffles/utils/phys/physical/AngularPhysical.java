package waffles.utils.phys.physical;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.dynamics.AngularDynamics;

/**
 * An {@code AngularPhysical} object can handle angular kinetics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamics
 */
public interface AngularPhysical extends AngularDynamics
{
	/**
	 * Returns the dynamics of the {@code AngularPhysical}.
	 * 
	 * @return  an angular mutable
	 * 
	 * 
	 * @see AngularDynamics
	 */
	public abstract AngularDynamics.Mutable Dynamics();
	
	
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