package io;

/**
 * The utility class providing the output messages and errors.
 * 
 * @author Shener Yumer
 * @version 1.0
 */
public class Output {
	/**
	 * The welcoming message.
	 */
	public static final String WELCOME = "Welcome!\nPlease insert a number, the square root of which you need approximated!";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private Output() {}

	/**
	 * Prints out an error for an invalid square root operand.
	 * 
	 * @param number	The invalid square root operand
	 */
	public static final void noSqrt(double number) {
		System.err.println("No square root for " + number + "!");
	}
}
