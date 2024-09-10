package waffles.utils.phys.swarms.impulse;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.types.impact.ImpactDrivable;
import waffles.utils.phys.drones.linear.types.impact.ImpactDrivable.Dynamics;
import waffles.utils.phys.swarms.ImpactStrategy;

/**
 * A {@code LinearImpulse} strategy performs massless Newwtonian impulse collision.
 *
 * @author Waffles
 * @since 21 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see ImpactDrivable
 * @see ImpactStrategy
 */
public interface LinearImpulse<D extends ImpactDrivable> extends ImpactStrategy<D>
{	
	/**
	 * Returns the elasticity of the {@code LinearImpulse}.
	 * 
	 * @return  an elasticity coefficient
	 */
	public default float Elasticity()
	{
		return 1f;
	}
	
		
	@Override
	public default void onImpact(D src, D tgt, Vector p, long time)
	{
		Dynamics dyn1 = src.Dynamics();
		Dynamics dyn2 = tgt.Dynamics();
		
		Vector v1 = dyn1.LinSpeed();
		Vector v2 = dyn2.LinSpeed();
		Vector v = v2.minus(v1);
		
		float vDot = v.dot(p);
		float pDot = p.dot(p);
		
		
		float c = Elasticity();
		float pScl = vDot / pDot;
		
		Vector w1 = p.times(+ pScl * c);
		Vector w2 = p.times(- pScl * c);

		dyn1.setLinSpeed(v1.plus(w1));
		dyn2.setLinSpeed(v2.plus(w2));
	}
}