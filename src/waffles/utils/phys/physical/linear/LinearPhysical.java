package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.spatial.types.Movable;
import waffles.utils.phys.Physical;
import waffles.utils.phys.dynamics.linear.LinearDynamical;

/**
 * A {@code LinearPhysical} defines an object with linear Newtonian physics.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see Physical
 * @see LinearDynamical
 * @see Movable
 */
public interface LinearPhysical extends LinearDynamical.Mutable, Physical, Movable
{
	/**
	 * Returns the dynamics of the {@code LinearPhysical}.
	 * 
	 * @return  a linear dynamics
	 * 
	 * 
	 * @see LinearDynamical
	 */
	public abstract LinearDynamical Dynamics();

	
	// TODO
	public static int i = 0;
	
	@Override
	public default void onUpdate(long time)
	{		
		Vector vLin = LinSpeed();

		float sLin = time / Mass();
//		vLin = vLin.plus(Force().times(sLin));
		Vector v = vLin.times(time / 1000f);

		setLinSpeed(vLin);
		moveFor(v);
		

//		b.addLinSpeed(Gravity().times(sLin));
	}

	@Override
	public default void setLinSpeed(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setLinSpeed(v);
		}
	}
	
	@Override
	public default void setMass(float m)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setMass(m);
		}
	}
	
	
	@Override
	public default Vector LinSpeed()
	{
		return Dynamics().LinSpeed();
	}
	
	@Override
	public default float Mass()
	{
		return Dynamics().Mass();
	}
}