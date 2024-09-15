package waffles.utils.phys.swarms.impulse;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.linear.types.impact.ImpactDrivable;
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
		Vector v1 = src.LinSpeed();
		Vector v2 = tgt.LinSpeed();
		Vector v = v2.minus(v1);
		
		float vDot = v.dot(p);
		float pDot = p.dot(p);
		
		
		float c = Elasticity();
		float pScl = vDot / pDot;
		
		Vector w1 = p.times(+ pScl * c);
		Vector w2 = p.times(- pScl * c);

		src.speedFor(w1);
		tgt.speedFor(w2);
	}
}