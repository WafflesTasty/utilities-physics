package zeno.util.phys.state;

import zeno.util.algebra.tensors.vectors.Vector;

/**
 * The {@code IForce} interface defines a physical force that acts on objects.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 */
public interface IForce
{
	/**
	 * Returns the vector of the {@code IForce}.
	 * 
	 * @return  the force vector
	 * @see Vector
	 */
	public abstract Vector Vector();
	
	/**
	 * Returns the origin of the {@code IForce}.
	 * 
	 * @return  the origin vector
	 * @see Vector
	 */
	public abstract Vector Origin();
}