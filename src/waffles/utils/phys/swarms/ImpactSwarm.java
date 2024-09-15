package waffles.utils.phys.swarms;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.phys.drones.Impactable;
import waffles.utils.phys.drones.Impactable.Dynamics;
import waffles.utils.phys.utilities.sets.CycledSet;

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
		Dynamics dyn1 = src.Dynamics();
		Dynamics dyn2 = tgt.Dynamics();
		
		CycledSet<Impactable> set1 = dyn1.Impacts();
		CycledSet<Impactable> set2 = dyn2.Impacts();

		if(set1.assume(tgt) && set2.assume(src))
		{
			onImpact(src, tgt, pnt, time);
		}
	}

	@Override
	public void onPulse(D src, long time)
	{
		src.Dynamics().Impacts().cycle();	
		super.onPulse(src, time);
	}
}