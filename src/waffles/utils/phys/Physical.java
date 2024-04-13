package waffles.utils.phys;

import waffles.utils.geom.Collidable;
import waffles.utils.phys.utilities.events.SynchroEvent;

/**
 * A {@code Physical} object can be managed in physics simulations.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see SynchroEvent
 * @see Collidable
 */
public interface Physical extends Collidable, SynchroEvent
{
	// NOT APPLICABLE
}