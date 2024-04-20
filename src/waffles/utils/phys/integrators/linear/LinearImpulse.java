package waffles.utils.phys.integrators.linear;

import waffles.utils.algebra.elements.linear.matrix.Matrices;
import waffles.utils.algebra.elements.linear.matrix.Matrix;
import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.integrators.Integrator;
import waffles.utils.phys.physical.linear.LinearPhysical;
import waffles.utils.sets.indexed.delegate.List;
import waffles.utils.sets.keymaps.delegate.JHashMap;
import waffles.utils.tools.primitives.Floats;

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
	private float cElast;
	private JHashMap<P, List<P>> prev, curr;
	
	/**
	 * Creates a new {@code LinearImpulse}.
	 */
	public LinearImpulse()
	{
		prev = new JHashMap<>();
		curr = new JHashMap<>();
		cElast = 1f;
	}
	
	/**
	 * Changes the cElast of the {@code LinearImpulse}.
	 * 
	 * @param e  a default cElast
	 */
	public void setElasticity(float e)
	{
		cElast = e;
	}
	
	
	@Override
	public float elasticity(P src, P tgt)
	{
		return cElast;
	}
	
	@Override
	public void bounce(P src, P tgt, Vector p, float c)
	{
		if(checkMap(src, tgt))
			return;
		if(checkMap(tgt, src))
			return;

		float m1 = src.Mass();
		float m2 = tgt.Mass();
		
		Vector v1 = src.LinSpeed();
		Vector v2 = tgt.LinSpeed();
		Vector v = v2.minus(v1);
		
		float vDot = v.dot(p);
		float pDot = p.dot(p);

		
		float mAvg = (m1 + m2) / 2;
		float pScl = vDot / (pDot * mAvg);
		
		Vector w1 = p.times(+m2 * pScl * c);
		Vector w2 = p.times(-m1 * pScl * c);

		src.setLinSpeed(v1.plus(w1));
		tgt.setLinSpeed(v2.plus(w2));
	}
	
	@Override
	public void bounce(P src, Vector p, float c)
	{
		Vector v1 = src.LinSpeed();
		if(v1.dot(p) <= 0)
		{
			Matrix m = Matrices.reflection(p);
			v1 = m.times(v1).times(c);
			src.setLinSpeed(v1);
		}
	}
		
	@Override
	public void update(P src, long time)
	{	
		float dt = time / 1000f;
		float max = src.MaxLinSpeed();
		Vector v = src.LinSpeed();

		
		float nrm = v.normSqr();
		if(nrm < max * max)
			v = v.times(dt);
		else
		{
			nrm = max / Floats.sqrt(nrm);
			v = v.times(nrm * dt);
		}
		
		
		src.moveFor(v);
		List<P> list = curr.remove(src);
		prev.put(src, list);
	}
	
	boolean checkMap(P src, P tgt)
	{
		List<P> list = prev.get(src);
		if(list == null)
		{
			list = new List<>();
			curr.put(src, list);
		}
		
		if(list.contains(tgt))
		{
			return true;
		}
		
		list.add(tgt);
		return false;
	}
}