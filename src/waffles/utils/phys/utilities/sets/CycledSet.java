package waffles.utils.phys.utilities.sets;

import java.util.Iterator;

import waffles.utils.sets.mutable.JHashSet;

/**
 * A {@code CycledSet} defines a set of objects which are cycled through.
 * With each {@link #cycle()}, this set iterates over all objects which
 * have been assumed since the last {@link #cycle()}, but not
 * in the one previous. This set is used in various
 * impact resolution algorithms.
 * 
 * @author Waffles
 * @since 19 Aug 2024
 * @version 1.0
 *
 *
 * @param <O>  an object type
 */
public class CycledSet<O>
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
			{
				prev = curr;
				curr = new JHashSet<>();
				return null;
			}
			
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
	 * Assume an object into the {@code CycledSet}.
	 * 
	 * @param obj  a target object
	 */
	public void assume(O obj)
	{
		if(!curr.contains(obj))
		{
			curr.add(obj);
		}
	}

	/**
	 * Cycles the state of the {@code CycledSet}.
	 * 
	 * @return  a cycle iterable
	 */
	public Iterable<O> cycle()
	{
		return () -> new Cycle();
	}
}