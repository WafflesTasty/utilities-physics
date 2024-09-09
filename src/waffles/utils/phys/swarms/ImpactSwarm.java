package waffles.utils.phys.swarms;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.utilities.sets.CycledSet;
import waffles.utils.phys.utilities.sets.Impact;

/**
 * An {@code ImpactSwarm} is a swarm which updates drone pairs on impact.
 *
 * @author Waffles
 * @since 21 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see ImpactStrategy
 * @see PairedSwarm
 * @see Impactable
 */
public abstract class ImpactSwarm<D extends Impactable> extends PairedSwarm<D> implements ImpactStrategy<D>
{
	private ImpactStrategy<D> ImpactStrategy()
	{
		if(Strategy() != null)
		{
			if(Strategy() instanceof ImpactStrategy<D>)
			{
				return (ImpactStrategy<D>) Strategy();
			}
		}
		
		return null;
	}
	
	
	@Override
	public void onImpact(D src, D tgt, Vector pnt, long time)
	{
		ImpactStrategy<D> str = ImpactStrategy();
		if(str != null)
		{
			str.onImpact(src, tgt, pnt, time);
		}
	}
	
	@Override
	public void onHit(D src, D tgt, Vector pnt, long time)
	{
		CycledSet<Impact> set1 = src.Dynamics().Impacts();
		CycledSet<Impact> set2 = tgt.Dynamics().Impacts();

		set1.assume(new Impact(tgt, pnt.times(+1f)));
		set2.assume(new Impact(src, pnt.times(-1f)));
	}

	@Override
	public void onPulse(D src, long time)
	{
		CycledSet<Impact> set = src.Dynamics().Impacts();
		for(Impact imp : set.cycle())
		{
			D tgt = (D) imp.Target();
			Vector pnt = imp.Penetration();
			onImpact(src, tgt, pnt, time);
		}
		
		super.onPulse(src, time);
	}
}