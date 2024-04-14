package waffles.utils.phys.integrators.linear;

import waffles.utils.algebra.elements.linear.matrix.Matrices;
import waffles.utils.algebra.elements.linear.matrix.Matrix;
import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.integrators.Integrator;
import waffles.utils.phys.physical.linear.LinearPhysical;

/**
 * A {@code LinearImpulse} integrates linear impulse collisions.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 *
 * @param <P>  a physical type
 * @see LinearPhysical
 * @see Integrator
 */
public class LinearImpulse<P extends LinearPhysical> implements Integrator<P>
{	
	@Override
	public void bounce(P src, P tgt, Vector p, float c)
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
	
	@Override
	public void bounce(P src, Vector p, float c)
	{
		Vector v1 = src.LinSpeed();
		if(v1.dot(p) <= 0)
		{
			Matrix m = Matrices.reflection(p);
			src.setLinSpeed(m.times(v1).times(c));
		}
	}
	
	@Override
	public void update(P src, long time)
	{		
		Vector vLin = src.LinSpeed();
		Vector v = vLin.times(time / 1000f);

		src.setLinSpeed(vLin);
		src.moveFor(v);
	}
}