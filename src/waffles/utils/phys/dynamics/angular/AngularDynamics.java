package waffles.utils.phys.dynamics.angular;

import waffles.utils.geom.spatial.data.spin.Spin;
import waffles.utils.geom.spatial.maps.fixed.linear.Rotation;

/**
 * An {@code AngularDynamics} defines a basic {@code AngularDynamical.Mutable} implementation.
 *
 * @author Waffles
 * @since 13 Apr 2024
 * @version 1.1
 * 
 * 
 * @see AngularDynamical
 */
public class AngularDynamics implements AngularDynamical.Mutable
{
	private Spin vel;
	private float inertia;
	
	/**
	 * Creates a new {@code AngularDynamics}.
	 * 
	 * @param dim  a vector dimension
	 */
	public AngularDynamics(int dim)
	{
		vel = Rotation.Default(dim);
	}
	
		
	@Override
	public void setRotSpeed(Spin s)
	{
		vel = s;
	}

	@Override
	public void setInertia(float i)
	{
		inertia = i;
	}

	@Override
	public Spin RotSpeed()
	{
		return vel;
	}

	@Override
	public float Inertia()
	{
		return inertia;
	}	
}