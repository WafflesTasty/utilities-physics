package waffles.utils.phys.utilities.sets;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collision.Response;
import waffles.utils.phys.Dynamical;

/**
 * An {@code Impact} contains target and penetration of a {@code Dynamical} collision.
 *
 * @author Waffles
 * @since 05 Sep 2024
 * @version 1.0
 */
public class Impact
{
	private Vector pnt;
	private Dynamical target;
	
	/**
	 * Creates a new {@code Impact}.
	 * 
	 * @param tgt  a target impactable
	 * @param p    a penetration vector
	 * 
	 * 
	 * @see Dynamical
	 * @see Response
	 */
	public Impact(Dynamical tgt, Vector p)
	{
		target = tgt;
		pnt = p;
	}
	
	
	/**
	 * Returns the penetration of the {@code Impact}.
	 * 
	 * @return  a penetration vector
	 * 
	 * 
	 * @see Vector
	 */
	public Vector Penetration()
	{
		return pnt;
	}
	
	/**
	 * Returns the target of the {@code Impact}.
	 * 
	 * @return  an impact target
	 * 
	 * 
	 * @see Dynamical
	 */
	public Dynamical Target()
	{
		return target;
	}
	
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Impact)
		{
			Dynamical tgt = ((Impact) o).Target();
			return target.equals(tgt);
		}
		
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return target.hashCode();
	}
}
