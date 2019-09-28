package zeno.util.phys.utilities;

import zeno.util.tools.Floats;

/**
 * The {@code Physics} class provides static access to basic physics utilities in euclidian space.
 * 
 * @author Zeno
 * @since Oct 16, 2014
 * @version 1.0
 */
public final class Physics
{
	/**
	 * Defines the universal gravity constant.
	 */
	public static final float UNIVERSAL_G = 6.673f * Floats.pow(10, -11);
	
	/**
	 * Defines the approximate mass of earth.
	 */
	public static final float EARTH_MASS = 5.97219f * Floats.pow(10, 24);
	
	/**
	 * Defines the approximate radius of earth.
	 */
	public static final float EARTH_RAD = 6371009f;

	
	/**
	 * Defines the local gravity constant on earth.
	 */
	public static final float EARTH_G = UNIVERSAL_G * EARTH_MASS / (EARTH_RAD * EARTH_RAD);

	
	private Physics()
	{
		// NOT APPLICABLE
	}
}