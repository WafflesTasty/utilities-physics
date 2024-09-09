package waffles.utils.phys.swarms.isolator;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.LinearDetectable;
import waffles.utils.phys.swarms.PairedStrategy;
import waffles.utils.phys.utilities.sets.Impact;
import waffles.utils.sets.mutable.JHashSet;

/**
 * A {@code LinearIsolation} strategy applies forces to drones to drive them apart.
 *
 * @author Waffles
 * @since 08 Sep 2024
 * @version 1.0
 * 
 * 
 * @param <D>  a drone type
 * @see LinearDetectable
 * @see PairedStrategy
 */
public interface LinearIsolation<D extends LinearDetectable> extends PairedStrategy<D>
{
	/**
	 * Returns the scale of the isolation force.
	 * 
	 * @return  a force multiplier
	 */
	public default float IsolationScale()
	{
		return 1f;
	}
	
	
	@Override
	public default void onHit(D src, D tgt, Vector pnt, long time)
	{
		JHashSet<Impact> set1 = src.Dynamics().Detects();
		JHashSet<Impact> set2 = tgt.Dynamics().Detects();

		set1.add(new Impact(tgt, pnt.times(+1f)));
		set2.add(new Impact(src, pnt.times(-1f)));
	}
	
	@Override
	public default void onPulse(D src, long time)
	{
		JHashSet<Impact> set = src.Dynamics().Detects();
		Vector vFrc = Vectors.create(src.Dimension());

		int count = 0;
		for(Impact imp : set)
		{
			D tgt = (D) imp.Target();
			Vector p = imp.Penetration();
			Vector v = tgt.LinSpeed();
			
			vFrc = vFrc.minus(v);
			vFrc = vFrc.plus(p);

			count++;
		}
		
		if(count > 0)
		{
			vFrc = vFrc.times(1f / count);
		}
		
		
		float fMul = IsolationScale();
		vFrc = vFrc.times(fMul);
		src.powerFor(vFrc);
	}
}