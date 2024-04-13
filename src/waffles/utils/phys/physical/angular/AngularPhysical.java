package waffles.utils.phys.physical.angular;

import waffles.utils.algebra.elements.linear.vector.Vector;
import waffles.utils.geom.spatial.types.Rotatable;
import waffles.utils.phys.Physical;
import waffles.utils.phys.dynamics.angular.AngularDynamical;

/**
 * An {@code AngularPhysical} defines an object with angular Newtonian physics.
 *
 * @author Waffles
 * @since 05 Apr 2024
 * @version 1.1
 * 
 * 
 * @see Physical
 * @see AngularDynamical
 * @see Rotatable
 */
public interface AngularPhysical extends AngularDynamical.Mutable, Physical, Rotatable
{
	/**
	 * Returns the dynamics of the {@code AngularPhysical}.
	 * 
	 * @return  an angular dynamics
	 * 
	 * 
	 * @see AngularDynamical
	 */
	public abstract AngularDynamical Dynamics();

	
	// TODO
	public static int i = 0;
	
	@Override
	public default void onUpdate(long time)
	{
//		Vector vRot = RotSpeed();
//
//		float sRot = time / Inertia();
//		vLin = vLin.plus(Force().times(sLin));
//		Vector v = vRot.times(time / 1000f);
//
//		float a = v.norm();
//		v = v.times(1f / a);
//		setRotSpeed(vRot);
//		rotateFor(v, a);
		

//		b.addLinSpeed(Gravity().times(sLin));
	}

	@Override
	public default void setRotSpeed(Vector v)
	{
		AngularDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setRotSpeed(v);
		}
	}
	
	@Override
	public default void setInertia(float i)
	{
		AngularDynamical.Mutable src = Dynamics().Mutator();
		if(src != null)
		{
			src.setInertia(i);
		}
	}


	@Override
	public default Vector RotSpeed()
	{
		return Dynamics().RotSpeed();
	}
	
	@Override
	public default float Inertia()
	{
		return Dynamics().Inertia();
	}
}