package waffles.utils.phys.integrators.linear;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.algebra.elements.linear.vector.Vectors;
import waffles.utils.phys.physical.linear.LinearPhysical;

/**
 * A {@code LinearForce} integrates linear impulse collisions and resolves linear forces.
 * The {@code #Force(LinearPhysical)} method can be overridden to define external forces on an object.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 *
 *
 * @param <P>  a physical type
 * @see LinearPhysical
 * @see LinearImpulse
 */
public class LinearForce<P extends LinearPhysical> extends LinearImpulse<P>
{	
	private Vector vDefault;
	
	/**
	 * Creates a new {@code LinearForce}.
	 * 
	 * @param dim  a vector dimension
	 */
	public LinearForce(int dim)
	{
		vDefault = Vectors.create(dim);
	}
		
	/**
	 * Changes the default force {@code Vector}.
	 * This can be used in cases where the external
	 * force acting on all objects is constant.
	 * 
	 * @param v  a force vector
	 * 
	 * 
	 * @see Vector
	 */
	public void setForce(Vector v)
	{
		vDefault = v;
	}
	
	/**
	 * Returns the {@code Force} acting on an object.
	 * 
	 * @param src  a source object
	 * @return     an external force
	 * 
	 * 
	 * @see Vector
	 */
	public Vector Force(P src)
	{
		return vDefault;
	}


	@Override
	public void update(P src, long time)
	{
		float dt  = time / 1000f;
		float dtm = time / src.Mass();
		float ddt = dt * dt / 2;
		
		Vector vLin = src.LinSpeed();
		Vector aLin = src.LinAccel();
		Vector fLin = src.LinForce();
		
		
		Vector fNew = fLin.plus(Force(src));
		Vector aNew = fNew.times(dtm).plus(aLin).times(0.5f);
		Vector vNew = vLin.plus(aLin.plus(aNew).times(dt / 2));
		Vector xNew = vLin.times(dt).plus(aLin.times(ddt));

		src.setLinAccel(aNew);
		src.setLinSpeed(vNew);
		src.moveFor(xNew);
	}
}