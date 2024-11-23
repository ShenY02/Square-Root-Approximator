package io;

/**
 * The utility class providing the allowed input possibilities
 * in the form of regular expressions.
 * 
 * @author Shener Yumer
 * @version 1.0
 */
public class Input {
	/**
	 * The exit command regex.
	 */
	public static final String EXIT = "exit";

	/**
	 * The regex for a floating point number.
	 */
	public static final String NUMBER = "-?([1-9][0-9]*|0)[.]?[0-9]*";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private Input() {}
}
