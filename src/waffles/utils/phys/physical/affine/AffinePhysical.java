package waffles.utils.phys.physical.affine;

import waffles.utils.geom.collidable.geometric.AffineOriented;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.physical.AngularPhysical;
import waffles.utils.phys.physical.aligned.AlignedPhysical;

/**
 * An {@code AffinePhysical} defines an affine-oriented object with general Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see AlignedPhysical
 * @see AngularPhysical
 * @see AffineOriented
 */
public interface AffinePhysical extends AffineOriented, AlignedPhysical, AngularPhysical
{
	@Override
	public abstract Dynamical.Mutable Dynamics();
}