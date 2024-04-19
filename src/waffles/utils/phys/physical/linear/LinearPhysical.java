package waffles.utils.phys.physical.linear;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.Collidable;
import waffles.utils.geom.spatial.types.Movable;
import waffles.utils.phys.dynamics.linear.LinearDynamical;
import waffles.utils.tools.primitives.Floats;

/**
 * A {@code LinearPhysical} defines a collidable object with linear Newtonian physics.
 * Its maximum acceleration is capped by the maximum speed of its {@code Dynamics}.
 * This makes it safer to integrate over while still allowing the internal
 * value to be adjusted arbitrarily.
 *
 * @author Waffles
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * 
 * @see LinearDynamical
 * @see Collidable
 * @see Movable
 */
public interface LinearPhysical extends LinearDynamical.Mutable, Collidable, Movable
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

	
	@Override
	public default void setMaxLinSpeed(float v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setMaxLinSpeed(v);
		}
	}
	
	@Override
	public default void setLinAccel(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			Vector w = v;
			
			float vel = w.normSqr();
			float max = src.MaxLinSpeed();
			if(vel > max * max)
			{
				float s = max / Floats.sqrt(vel);
				w = v.times(s);
			}
			
			src.setLinAccel(w);
		}
	}
	
	@Override
	public default void setLinForce(Vector v)
	{
		LinearDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setLinForce(v);
		}
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
	public default float MaxLinSpeed()
	{
		return Dynamics().MaxLinSpeed();
	}
	
	@Override
	public default Vector LinAccel()
	{
		return Dynamics().LinAccel();
	}
	
	@Override
	public default Vector LinForce()
	{
		return Dynamics().LinForce();
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