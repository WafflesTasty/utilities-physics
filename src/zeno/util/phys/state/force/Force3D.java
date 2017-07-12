package zeno.util.phys.state.force;

import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.phys.state.IForce;

/**
 * The {@code Force3D} class defines a force acting in a three-dimensional environment.
 * 
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see IForce
 */
public class Force3D implements IForce
{
	private Vector3 origin, vector;
		
	/**
	 * Creates a new {@code Force3D}.
	 * 
	 * @param v  a force vector
	 * @param o  an origin vector
	 * @see Vector3
	 */
	public Force3D(Vector3 v, Vector3 o)
	{
		origin = o;
		vector = v;
	}
	
	/**
	 * Creates a new {@code Force3D}.
	 * 
	 * @param x  a force x-coördinate
	 * @param y  a force y-coördinate
	 * @param z  a force z-coördinate
	 */
	public Force3D(float x, float y, float z)
	{
		this(new Vector3(x, y, z));
	}
	
	/**
	 * Creates a new {@code Force3D}.
	 * 
	 * @param v  a force vector
	 * @see Vector3
	 */
	public Force3D(Vector3 v)
	{
		this(v, new Vector3());
	}
	
	/**
	 * Creates a new {@code Force3D}.
	 */
	public Force3D()
	{
		this(new Vector3());
	}
	

	/**
	 * Changes the origin of the {@code Force3D}.
	 * 
	 * @param v  a new origin vector
	 * @see Vector3
	 */
	public void setOrigin(Vector3 v)
	{
		origin = v;
	}
	
	/**
	 * Changes the vector of the {@code Force3D}.
	 * @param v  a new force vector
	 * @see Vector3
	 */
	public void setVector(Vector3 v)
	{
		vector = v;
	}
		
	
	/**
	 * Returns the origin of the {@code Force3D}.
	 * 
	 * @return  the force origin
	 * @see Vector3
	 */
	@Override
	public Vector3 Origin()
	{
		return origin;
	}
	
	/**
	 * Returns the vector of the {@code Force3D}.
	 * 
	 * @return  the force vector
	 * @see Vector3
	 */
	@Override
	public Vector3 Vector()
	{
		return vector;
	}
	
	/**
	 * Returns the torque of the {@code Force3D}.
	 * 
	 * @return  the torque vector
	 * @see Vector3
	 */
	public Vector3 Torque()
	{
		return origin.cross(vector);
	}
}