package zeno.util.phys.state.force;

import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.phys.state.IForce;

/**
 * The {@code Force2D} class defines a force acting in a two-dimensional environment.
 * 
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see IForce
 */
public class Force2D implements IForce
{
	private Vector2 origin, vector;
		
	/**
	 * Creates a new {@code Force2D}.
	 * 
	 * @param v  a force vector
	 * @param o  an origin vector
	 * @see Vector2
	 */
	public Force2D(Vector2 v, Vector2 o)
	{
		origin = o;
		vector = v;
	}
	
	/**
	 * Creates a new {@code Force2D}.
	 * 
	 * @param x  a force x-coördinate
	 * @param y  a force y-coördinate
	 */
	public Force2D(float x, float y)
	{
		this(new Vector2(x, y));
	}
	
	/**
	 * Creates a new {@code Force2D}.
	 * 
	 * @param v  a force vector
	 * @see Vector2
	 */
	public Force2D(Vector2 v)
	{
		this(v, new Vector2());
	}
	
	/**
	 * Creates a new {@code Force2D}.
	 */
	public Force2D()
	{
		this(new Vector2());
	}
	

	/**
	 * Changes the origin of the {@code Force2D}.
	 * 
	 * @param v  a new origin vector
	 * @see Vector2
	 */
	public void setOrigin(Vector2 v)
	{
		origin = v;
	}
	
	/**
	 * Changes the vector of the {@code Force2D}.
	 * @param v  a new force vector
	 * @see Vector2
	 */
	public void setVector(Vector2 v)
	{
		vector = v;
	}
		
	
	/**
	 * Returns the origin of the {@code Force2D}.
	 * 
	 * @return  the force origin
	 * @see Vector2
	 */
	@Override
	public Vector2 Origin()
	{
		return origin;
	}
	
	/**
	 * Returns the vector of the {@code Force2D}.
	 * 
	 * @return  the force vector
	 * @see Vector2
	 */
	@Override
	public Vector2 Vector()
	{
		return vector;
	}
	
	/**
	 * Returns the torque of the {@code Force2D}.
	 * 
	 * @return  the torque angle
	 */
	public float Torque()
	{
		return origin.perpdot(vector);
	}
}