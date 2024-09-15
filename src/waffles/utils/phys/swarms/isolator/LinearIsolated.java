package waffles.utils.phys.swarms.isolator;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.drones.linear.LinearDynamical;

/**
 * A {@code LinearIsolated} object is used as a drone in a {@code LinearIsolator}.
 *
 * @author Waffles
 * @since 22 Aug 2024
 * @version 1.0
 * 
 * 
 * @see LinearDynamical
 */
public interface LinearIsolated extends LinearDynamical
{
	/**
	 * The {@code LinearIsolated.Dynamics} refreshes its isolation force on update.
	 *
	 * @author Waffles
	 * @since 22 Aug 2024
	 * @version 1.1
	 *
	 * 
	 * @see LinearDynamical
	 */
	public static class Dynamics extends LinearDynamical.Dynamics
	{
		private int count;
		private Vector vFrc;
		private float fScale;

		/**
		 * Creates a new {@code Dynamics}.
		 * 
		 * @param d  a target drone
		 * 
		 * 
		 * @see LinearIsolated
		 */
		public Dynamics(LinearIsolated d)
		{
			super(d);
			fScale = 1f;
			reset();
		}
		
		/**
		 * Adds an isolator to the {@code Dynamics}.
		 * 
		 * @param v  an isolator force
		 * 
		 * 
		 * @see Vector
		 */
		public void addIsolator(Vector v)
		{
			vFrc = vFrc.plus(v);
			count++;
		}

		/**
		 * Changes the scale of the isolation force.
		 * 
		 * @param s  a force multiplier
		 */
		public void setIsolationScale(float s)
		{
			fScale = s;
		}
		
		/**
		 * Returns the scale of the isolation force.
		 * 
		 * @return  a force multiplier
		 */
		public float IsolationScale()
		{
			return fScale;
		}
		

		@Override
		public void onUpdate(long time)
		{
			if(count > 0)
			{
				float scl = IsolationScale();
				vFrc = vFrc.times(scl / count);
				Drone().powerFor(vFrc);
			}
			
			super.onUpdate(time);
			reset();
		}
		
		private void reset()
		{
			int dim = Drone().Dimension();
			vFrc = Vectors.create(dim);
			count = 0;
		}
	}
	
		
	/**
	 * Returns the isolation scale of the {@code LinearIsolated}.
	 * 
	 * @return  a force multiplier
	 */
	public default float IsolationScale()
	{
		return Dynamics().IsolationScale();
	}
	
	/**
	 * Changes the isolation scale of the {@code LinearIsolated}.
	 * 
	 * @param s  a force multiplier
	 */
	public default void setIsolationScale(float s)
	{
		Dynamics().setIsolationScale(s);
	}
	
	/**
	 * Adds an isolation force to the {@code LinearIsolated}.
	 * 
	 * @param v  an isolation force
	 * 
	 * 
	 * @see Vector
	 */
	public default void addIsolator(Vector v)
	{
		Dynamics().addIsolator(v);
	}
	
	
	@Override
	public abstract Dynamics Dynamics();
}