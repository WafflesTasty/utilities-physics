package zeno.util.phys.logic;

import java.util.HashSet;
import java.util.Set;

import zeno.util.algebra.tensors.vectors.fixed.Vector3;
import zeno.util.phys.state.force.Force3D;
import zeno.util.phys.state.force.Torque3D;
import zeno.util.phys.state.objects.IPhysical3D;

/**
 * The {@code Integrator3D} class defines a physics integrator for three-dimensional space.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see Integrator
 */
public abstract class Integrator3D implements Integrator
{
	private Vector3 vLinear;
	private Vector3 vAngular;
	
	private IPhysical3D object;
	private Set<Force3D> forces;
	private Set<Torque3D> torques;
	
	/**
	 * Creates a new {@code Integrator3D}.
	 * 
	 * @param o  a target object
	 * @see IPhysical3D
	 */
	public Integrator3D(IPhysical3D o)
	{
		forces = new HashSet<>();
		torques = new HashSet<>();
		vAngular = new Vector3();
		vLinear = new Vector3();
		
		object = o;
	}	
			
	/**
	 * Changes the rotate speed of the {@code Integrator3D}.
	 * 
	 * @param vel  a new angular speed
	 * @see Vector3
	 */
	public void setRotSpeed(Vector3 vel)
	{
		vAngular = vel;
	}
	
	/**
	 * Changes the linear speed of the {@code Integrator3D}.
	 * 
	 * @param vel  a new linear speed
	 * @see Vector3
	 */
	public void setLinSpeed(Vector3 vel)
	{
		vLinear = vel;
	}
	
	/**
	 * Changes the object of the {@code Integrator3D}.
	 * 
	 * @param o  a new object
	 * @see IPhysical3D
	 */
	public void setObject(IPhysical3D o)
	{
		object = o;
	}

	/**
	 * Removes a torque from the {@code Integrator3D}.
	 * 
	 * @param torque  a torque to remove
	 * @see Torque3D
	 */
	public void remove(Torque3D torque)
	{
		torques.remove(torque);
	}
	
	/**
	 * Removes a force from the {@code Integrator3D}.
	 * 
	 * @param force  a force to remove
	 * @see Force3D
	 */
	public void remove(Force3D force)
	{
		forces.remove(force);
	}

	/**
	 * Adds a torque to the {@code Integrator3D}.
	 * 
	 * @param torque  a torque to add
	 * @see Torque3D
	 */
	public void add(Torque3D torque)
	{
		torques.add(torque);
	}
	
	/**
	 * Adds a force to the {@code Integrator3D}.
	 * 
	 * @param force  a force to add
	 * @see Force3D
	 */
	public void add(Force3D force)
	{
		forces.add(force);
	}

	
	/**
	 * Returns the total force in the {@code Integrator3D}.
	 * 
	 * @return  the total active force
	 * @see Vector3
	 */
	public Vector3 TotalForce()
	{
		Vector3 total = new Vector3();
		
		for(Force3D force : Forces())
		{
			total = total.plus(force.Vector());
		}
		
		return total;
	}
	
	/**
	 * Returns the total torque in the {@code Integrator3D}.
	 * 
	 * @return  the total active torque
	 * @see Vector3
	 */
	public Vector3 TotalTorque()
	{
		Vector3 total = new Vector3();
		
		for(Force3D force : Forces())
		{
			total = total.plus(force.Torque());
		}
		
		for(Torque3D torque : Torques())
		{
			total = total.plus(torque.Vector());
		}
		
		return total;
	}
	
	/**
	 * Returns the torques of the {@code Integrator3D}.
	 * 
	 * @return  the integrator's torques
	 * @see Torque3D
	 * @see Set
	 */
	public Set<Torque3D> Torques()
	{
		return torques;
	}
	
	/**
	 * Returns the forces of the {@code Integrator3D}.
	 * 
	 * @return  the integrator's forces
	 * @see Force3D
	 * @see Set
	 */
	public Set<Force3D> Forces()
	{
		return forces;
	}
	
	/**
	 * Returns the object of the {@code Integrator3D}.
	 * 
	 * @return  the integrator's object
	 * @see IPhysical3D
	 */
	public IPhysical3D Object()
	{
		return object;
	}

	/**
	 * Returns the linear speed of the {@code Integrator3D}.
	 * 
	 * @return  the linear speed
	 * @see Vector3
	 */
	public Vector3 LinSpeed()
	{
		return vLinear;
	}
	
	/**
	 * Returns the rotate speed of the {@code Integrator3D}.
	 * 
	 * @return  the rotate speed
	 * @see Vector3
	 */
	public Vector3 RotSpeed()
	{
		return vAngular;
	}
}