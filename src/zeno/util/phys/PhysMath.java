package zeno.util.phys;

import zeno.util.tools.primitives.Floats;

/**
 * The {@code PhysMath} class contains basic physics calculations in euclidian space.
 * 
 * @author Zeno
 * @since Oct 16, 2104
 */
public abstract class PhysMath
{
	/**
	 * Defines the universal gravity constant.
	 */
	public static final float UNIVERSAL_G = 6.673f * Floats.pow(10, -11);
	
	/**
	 * Defines earth's mass.
	 */
	public static final float EARTH_MASS = 5.97219f * Floats.pow(10, 24);
	
	/**
	 * Defines earth's radius.
	 */
	public static final float EARTH_RAD = 6371009f;

	
	/**
	 * Defines earth's gravity constant.
	 */
	public static final float EARTH_G = UNIVERSAL_G * EARTH_MASS / (EARTH_RAD * EARTH_RAD);

	
	private PhysMath()
	{
		// NOT APPLICABLE
	}
}