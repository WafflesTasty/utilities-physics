package zeno.util.phys.state;

import zeno.util.algebra.tensors.vectors.Vector;

/**
 * The {@code ITorque} interface defines a physical torque that acts on objects.
 *
 * @author Zeno
 * @since Jul 14, 2017
 * @version 1.0
 */
public interface ITorque
{
	/**
	 * Returns the vector of the {@code IForce}.
	 * 
	 * @return  the force vector
	 * @see Vector
	 */
	public abstract Vector Vector();
}