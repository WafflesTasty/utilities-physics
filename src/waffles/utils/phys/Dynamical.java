package waffles.utils.phys;

import waffles.utils.geom.Collidable;
import waffles.utils.geom.utilities.Dimensional;
import waffles.utils.phys.utilities.events.SynchroEvent;

/**
 * A {@code Dynamical} object defines dynamics for use in a {@code Swarm}.
 *
 * @author Waffles
 * @since 11 Aug 2024
 * @version 1.0
 * 
 * 
 * @see Collidable
 */
public interface Dynamical extends Collidable
{
	/**
	 * The {@code Dynamics} defines the intrinsic time-dependent behavior of a {@code Dynamical} object.
	 *
	 * @author Waffles
	 * @since 08 Sep 2024
	 * @version 1.1
	 *
	 * 
	 * @see SynchroEvent
	 * @see Dimensional
	 */
	public static interface Dynamics extends Dimensional, SynchroEvent
	{
		// NOT APPLICABLE
	}
	
	
	/**
	 * Returns the dynamics of the {@code Dynamical}.
	 * 
	 * @return  a dynamics object
	 * 
	 * 
	 * @see Dynamics
	 */
	public abstract Dynamics Dynamics();
	
	
	@Override
	public default int Dimension()
	{
		return Dynamics().Dimension();
	}
}