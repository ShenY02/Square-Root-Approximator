import io.*;
import java.util.Scanner;
import math.Calculator;

/**
 * The Main class containing the program entry point.
 * Enables the functionality of the I/O. The user can
 * enter a floating point number and the program will
 * calculate the square root of the number and display the result.
 * If the user enters "exit", the program will terminate.
 * The program does support calculation of complex roots.
 * 
 * @author Shener Yumer
 * @version 1.0
 */
public class Main {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private Main() {}

	/**
	 * The main method containing the program entry point.
	 * 
	 * @param args	The command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(Output.WELCOME);

		Scanner sc = new Scanner(System.in);	// Enabling the user input stream
		
		do {
			String line = sc.nextLine().toLowerCase();

			if (line.matches(Input.EXIT)) break;	// Terminates the program
			if (line.matches(Input.NUMBER)) {
				double number = Double.parseDouble(line);
				String root = Double.toString(Calculator.squareRoot(number));

				// Decides whether to display the result as a real or complex number
				System.out.println((number >= 0) ? root : root + " i");
			}
		} while (true);	// Awaits further entries

		sc.close();	// Disabling the user input stream
	}
}