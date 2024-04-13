package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.matrix.Matrices;
import waffles.utils.algebra.elements.linear.matrix.Matrix;
import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.Physics;

/**
 * A {@code LinearPhysics} handles standard linear physics in a {@code Manifold}.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 *
 * @param <O>  an object type
 * @see LinearPhysical
 * @see Physics
 */
public class LinearPhysics<O extends LinearPhysical> extends Physics<O>
{
	/**
	 * Creates a new {@code LinearPhysics}.
	 * 
	 * @param s  a manifold space
	 * 
	 * 
	 * @see Manifold
	 */
	public LinearPhysics(Manifold<O> s)
	{
		super(s);
	}

	
	@Override
	public void bounce(O src, Vector p, float c)
	{
		Vector v1 = src.LinSpeed();
		if(v1.dot(p) <= 0)
		{
			Matrix m = Matrices.reflection(p);
			src.setLinSpeed(m.times(v1).times(c));
		}
	}
	
	@Override
	public void bounce(O src, O tgt, Vector p, float c)
	{
		float m1 = src.Mass();
		float m2 = tgt.Mass();
		
		Vector v1 = src.LinSpeed();
		Vector v2 = tgt.LinSpeed();
		Vector v = v2.minus(v1);
		
		float vDot = v.dot(p);
		float pDot = p.dot(p);

		
		float mAvg = (m1 + m2) / 2;
		float pScl = vDot / (pDot * mAvg);
		
		Vector w1 = p.times(+m2 * pScl);
		Vector w2 = p.times(-m1 * pScl);

		src.setLinSpeed(v1.plus(w1).times(c));
		tgt.setLinSpeed(v2.plus(w2).times(c));
	}
}