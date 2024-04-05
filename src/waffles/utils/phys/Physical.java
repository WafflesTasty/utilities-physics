package waffles.utils.phys;

import waffles.utils.phys.physical.AngularPhysical;
import waffles.utils.phys.physical.LinearPhysical;

/**
 * A {@code Physical} object can handle full-motion kinetics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularPhysical
 * @see LinearPhysical
 */
public interface Physical extends AngularPhysical, LinearPhysical
{
	@Override
	public abstract Dynamics.Mutable Dynamics();
}