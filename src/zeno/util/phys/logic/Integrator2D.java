package zeno.util.phys.logic;

import java.util.HashSet;
import java.util.Set;

import zeno.util.algebra.tensors.vectors.fixed.Vector2;
import zeno.util.phys.state.force.Force2D;
import zeno.util.phys.state.objects.IPhysical2D;

/**
 * The {@code Integrator2D} class defines a physics integrator for two-dimensional space.
 *
 * @author Zeno
 * @since Jul 12, 2017
 * @version 1.0
 * 
 * @see Integrator
 */
public abstract class Integrator2D implements Integrator
{
	private float vAngular;
	private Vector2 vLinear;
	
	private Set<Force2D> forces;
	private IPhysical2D object;
	
	/**
	 * Creates a new {@code Integrator2D}.
	 */
	public Integrator2D()
	{
		forces = new HashSet<>();
		vLinear = new Vector2();
		vAngular = 0f;
	}

	/**
	 * Returns the linear speed of the {@code Integrator2D}.
	 * 
	 * @return  the linear speed
	 * @see Vector2
	 */
	public Vector2 LinSpeed()
	{
		return vLinear;
	}
	
	/**
	 * Returns the physical object of the {@code Integrator2D}.
	 * 
	 * @return  the integrator's object
	 * @see IPhysical2D
	 */
	public IPhysical2D Object()
	{
		return object;
	}
	
	/**
	 * Returns the active forces of the {@code Integrator2D}.
	 * 
	 * @return  the integrator's forces
	 * @see Force2D
	 * @see Set
	 */
	public Set<Force2D> Forces()
	{
		return forces;
	}
	
	/**
	 * Returns the rotate speed of the {@code Integrator2D}.
	 * 
	 * @return  the rotate speed
	 */
	public float RotSpeed()
	{
		return vAngular;
	}
	
			
	/**
	 * Changes the rotate speed of the {@code Integrator2D}.
	 * 
	 * @param vel  a new angular speed
	 */
	public void setRotSpeed(float vel)
	{
		vAngular = vel;
	}
	
	/**
	 * Changes the linear speed of the {@code Integrator2D}.
	 * 
	 * @param vel  a new linear speed
	 * @see Vector2
	 */
	public void setLinSpeed(Vector2 vel)
	{
		vLinear = vel;
	}
	
	/**
	 * Changes the object of the {@code Integrator2D}.
	 * 
	 * @param o  a new object
	 * @see IPhysical2D
	 */
	public void setObject(IPhysical2D o)
	{
		object = o;
	}

	/**
	 * Removes a force from the {@code Integrator2D}.
	 * 
	 * @param force  a force to remove
	 * @see Force2D
	 */
	public void remove(Force2D force)
	{
		forces.remove(force);
	}

	/**
	 * Adds a force to the {@code Integrator2D}.
	 * 
	 * @param force  a force to add
	 * @see Force2D
	 */
	public void add(Force2D force)
	{
		forces.add(force);
	}
}