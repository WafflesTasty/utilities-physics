package waffles.utils.phys.utilities.sets;

import java.util.Iterator;

import waffles.utils.sets.mutable.JHashSet;

/**
 * A {@code CycledSet} defines a set of objects which are cycled through.
 * With each {@link #cycle()}, this set assigns all current objects to the
 * previous objects, and makes the current set empty. The {@link #iterator()}
 * traverses over all objects which have been assumed since the last
 * {@link #cycle()}, but not in the one previous. This set is
 * used in various impact resolution algorithms.
 * 
 * @author Waffles
 * @since 19 Aug 2024
 * @version 1.0
 *
 *
 * @param <O>  an object type
 * @see Iterable
 */
public class CycledSet<O> implements Iterable<O>
{
	/**
	 * A {@code Cycle} iterates through the current state of a {@code CycledSet}.
	 * Once iteration is finished, a new cycle of objects can be added.
	 *
	 * @author Waffles
	 * @since 04 Sep 2024
	 * @version 1.1
	 * 
	 * 
	 * @see Iterator
	 */
	public class Cycle implements Iterator<O>
	{
		private O next;
		private Iterator<O> cycle;
		
		/**
		 * Creates a new {@code Cycle}.
		 */
		public Cycle()
		{
			cycle = curr.iterator();
			next = findNext();
		}
		
		
		private O findNext()
		{
			if(!cycle.hasNext())
				return null;
			
			next = cycle.next();
			if(prev.contains(next))
			{
				return findNext();
			}
			
			return next;
		}
		
		@Override
		public boolean hasNext()
		{
			return next != null;
		}

		@Override
		public O next()
		{
			O curr = next;
			next = findNext();
			return curr;
		}
	}

	
	private JHashSet<O> prev;
	private JHashSet<O> curr;
	
	/**
	 * Creates a new {@code CycledSet}.
	 */
	public CycledSet()
	{
		prev = new JHashSet<>();
		curr = new JHashSet<>();
	}
	
	/**
	 * Assume an object in the {@code CycledSet}.
	 * 
	 * @param obj  a target object
	 * @return {@code true} if the object is assumed
	 */
	public boolean assume(O obj)
	{
		if(!curr.contains(obj))
		{
			curr.add(obj);
		}
		
		return !prev.contains(obj);
	}

	/**
	 * Cycles the state of the {@code CycledSet}.
	 */
	public void cycle()
	{
		prev = curr;
		curr = new JHashSet<>();
	}
	

	@Override
	public Cycle iterator()
	{
		return new Cycle();
	}
}