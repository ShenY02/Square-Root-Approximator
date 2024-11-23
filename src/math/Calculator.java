package math;

/**
 * The utility class providing the necessary facilities
 * for calculating the nearest to a number root, as well
 * as for calculating the square root of a number with a
 * very high precision.
 * 
 * @author Shener Yumer
 * @version 1.0
 */
public class Calculator {
	/**
	 * Buffer variable for the nearest upper root found.
	 */
	private static int nearestUpper;

	/**
	 * Buffer variable for the nearest lower root found.
	 */
	private static int nearestLower;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private Calculator() {}

	/**
	 * Helper method for finding the nearest integer root to
	 * the specified <b>target</b> value by using binary search.
	 * 
	 * @param low		The lowest value for the search range
	 * @param high		The highest value for the search range
	 * @param target	The targeted value to find the nearest root to
	 * @return		The nearest integer to the <b>target</b>'s root
	 */
	private static int nearestRoot(int low, int high, int target) {
		// Ensures that numbers around 0 and 1 don't cause
		// division by zero or create infinite recursions
		if (target < 2) return 1;

		int mid = (low + high) / 2;

		int square = mid * mid;
		if ((square > target) && ((mid < nearestUpper) || nearestUpper == 0)) {
			nearestUpper = mid;
			return nearestRoot(low, mid, target); // Recursively search lower
		} else if ((square < target) && ((mid > nearestLower) || nearestLower == 0)) {
			nearestLower = mid;
			return nearestRoot(mid, target, target); // Recursively search higher
		} else if (square == target) {
			// Buffer variable flushing
			nearestLower = 0;
			nearestUpper = 0;

			return mid;
		}

		// Calculating which found root's square is closer to the target
		int upperDiff = nearestUpper * nearestUpper - target;
		int lowerDiff = target - nearestLower * nearestLower;

		int nearest;
		if (!(upperDiff < 0 || lowerDiff < 0)) {
			// Picking the closer root, if the near upper root and the near lower root exist
			nearest = (upperDiff < lowerDiff) ? nearestUpper : nearestLower;
		} else {
			// If only one found root exists, return it
			nearest = (upperDiff < 0) ? nearestLower : nearestUpper;
		}

		// Buffer variable flushing
		nearestLower = 0;
		nearestUpper = 0;

		return nearest;
	}

	/**
	 * Method for finding the approximation of the square root of a number.
	 * 
	 * @param number	The given number
	 * @return		The approximation of the square root of the number
	 */
	public static double squareRoot(double number) {
		// Negating the number if it is negative so we can search for the real root
		if (number < 0 || number == -0) number = -number;
		
		// Skip trivial calculations
		if (number == 0 || number == 1) return number;

		// Searches for the nearest root to the target value
		double approx = nearestRoot(0, (int) number, (int) number);

		// The further the iterations, the better the approximation
		for (int i = 0; i < 30; i++) {
			// Adds an approximation adjustment to the current approximation
			approx += (number - (approx * approx)) / (2 * approx);
		}

		return approx;
	}
}
