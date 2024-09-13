package waffles.utils.phys.swarms.impulse;

import waffles.utils.geom.bounds.Bounds;
import waffles.utils.geom.collidable.Geometry;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.drones.linear.types.impact.ImpactDrivable;
import waffles.utils.phys.swarms.ImpactSwarm;
import waffles.utils.phys.swarms.bounds.BoundedImpulse;

/**
 * A {@code LinearImpulser} swarm performs collision resolution on drones through
 * the classical equations of linear momentum conservation. Drone collisions are evaluated
 * in pairs, giving each drone a new momentum through Newton's second law of motion.
 * All drones are treated as having equal mass, while the boundary is
 * treated as an object of infinite mass.
 *
 * @author Waffles
 * @since 10 Sep 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see ImpactDrivable
 * @see ImpactSwarm
 */
public class LinearImpulser<D extends ImpactDrivable> extends ImpactSwarm<D>
{
	/**
	 * A {@code LinearImpulse.Strategy} defines a basic impulse resolution strategy.
	 * Drones receive changes in their velocities when colliding with eachother or the bounds.
	 * Collision is resolved through classical impulse conversation equations.
	 * The mass of all drones is considered equal.
	 *
	 * @author Waffles
	 * @since 10 Sep 2024
	 * @version 1.1
	 *
	 * 
	 * @see BoundedImpulse
	 * @see LinearImpulse
	 */
	public class Strategy implements BoundedImpulse<D>, LinearImpulse<D>
	{				
		@Override
		public Geometry Bounds(int dim)
		{
			Bounds bnd = Manifold().Bounds();
			switch(bound)
			{
			case BALL:
				return bnd.Ball();
			case BOX:
				return bnd.Box();
			default:
				return null;
			}
		}		
		
		@Override
		public float Elasticity()
		{
			return cElast;
		}
	}
	
	
	private float cElast;
	private Bounds.Type bound;
	private Manifold<D> manifold;
	
	/**
	 * Creates a new {@code LinearMassImpulser}.
	 * 
	 * @param mfd  a drone manifold
	 * 
	 * 
	 * @see Manifold
	 */
	public LinearImpulser(Manifold<D> mfd)
	{
		bound = Bounds.Type.BOX;
		manifold = mfd;
		cElast = 1f;
	}
	
	/**
	 * Changes the bounds of the impulser.
	 * 
	 * @param bnd  a bounds type
	 * 
	 * 
	 * @see Bounds
	 */
	public void setBounds(Bounds.Type bnd)
	{
		bound = bnd;
	}
	
	/**
	 * Changes the elasticity of the impulser.
	 * 
	 * @param c  an elasticity coefficient
	 */
	public void setElasticity(float c)
	{
		cElast = c;
	}
	
	
	@Override
	public Manifold<D> Manifold()
	{
		return manifold;
	}

	@Override
	public Strategy Strategy()
	{
		return new Strategy();
	}
}
