package zeno.util.phys.state.force;

import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.phys.state.ITorque;

/**
 * The {@code Torque3D} class defines a torque acting in a three-dimensional environment.
 * 
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see ITorque
 */
public class Torque3D implements ITorque
{
	private Vector3 vector;

	/**
	 * Creates a new {@code Torque3D}.
	 * 
	 * @param x  a torque x-coördinate
	 * @param y  a torque y-coördinate
	 * @param z  a torque z-coördinate
	 */
	public Torque3D(float x, float y, float z)
	{
		this(new Vector3(x, y, z));
	}
	
	/**
	 * Creates a new {@code Torque3D}.
	 * 
	 * @param v  a torque vector
	 * @see Vector3
	 */
	public Torque3D(Vector3 v)
	{
		vector = v;
	}
	
	/**
	 * Creates a new {@code Torque3D}.
	 */
	public Torque3D()
	{
		this(new Vector3());
	}
	

	/**
	 * Changes the vector of the {@code Torque3D}.
	 * @param v  a new torque vector
	 * @see Vector3
	 */
	public void setVector(Vector3 v)
	{
		vector = v;
	}
	
	/**
	 * Returns the vector of the {@code Torque3D}.
	 * 
	 * @return  the torque vector
	 * @see Vector3
	 */
	@Override
	public Vector3 Vector()
	{
		return vector;
	}
}