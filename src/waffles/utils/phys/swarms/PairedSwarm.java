package waffles.utils.phys.swarms;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collision.Response;
import waffles.utils.geom.spaces.Manifold;
import waffles.utils.phys.Dynamical;
import waffles.utils.phys.Swarm;
import waffles.utils.sets.keymaps.Pair;

/**
 * A {@code PairedSwarm} is a swarm which can update its drones in pairs.
 *
 * @author Waffles
 * @since 21 Aug 2024
 * @version 1.0
 *
 *
 * @param <D>  a drone type
 * @see PairedStrategy
 * @see Dynamical
 * @see Swarm
 */
public abstract class PairedSwarm<D extends Dynamical> extends Swarm<D> implements PairedStrategy<D>
{
	private PairedStrategy<D> PairedStrategy()
	{
		if(Strategy() != null)
		{
			if(Strategy() instanceof PairedStrategy<D>)
			{
				return (PairedStrategy<D>) Strategy();
			}
		}
		
		return null;
	}
	
	
	@Override
	public abstract Manifold<D> Manifold();
	
	@Override
	public void onHit(D src, D tgt, Vector pnt, long time)
	{
		PairedStrategy<D> str = PairedStrategy();
		if(str != null)
		{
			str.onHit(src, tgt, pnt, time);
		}
	}

	@Override
	public void onPulse(D src, D tgt, long time)
	{
		PairedStrategy<D> str = PairedStrategy();
		if(str != null)
		{
			str.onPulse(src, tgt, time);
		}
		
		Response rsp = src.intersect(tgt);
		if(rsp.hasImpact())
		{	
			Vector pnt = rsp.Penetration();
			onHit(src, tgt, pnt, time);
		}
	}		
	
	@Override
	public void onUpdate(long time)
	{
		for(Pair<D, D> pair : Manifold().Pairs())
		{
			D src = pair.Key();
			D tgt = pair.Value();
			
			if(src != tgt)
			{
				onPulse(src, tgt, time); 
			}
		}
		
		super.onUpdate(time);
	}
}