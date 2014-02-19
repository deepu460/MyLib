package com.hr.plib.visual.console;

import static java.lang.System.out;

import com.hr.plib.core.array.PLArrays;

/**
 * This class handles all of the console-related menu methods. It can print
 * menus, customizable lines, and much else besides.
 * 
 * @author Harshavardhan Ramesh - Sep 18, 2013
 */
public class PLConsole {

	/**
	 * These are the type of possible positions for the text.
	 */
	public static enum PrintType {
		HEADER, FOOTNOTE;
	}

	/**
	 * Prints '-' 40 times & then prints a line.
	 */
	public static void printBreakLine() {
		printChar('-', 40);
	}

	/**
	 * Prints [c] x amount of times, where c is the first variable, a character,
	 * & x is the second variable, an integer. Effectively does the same as the
	 * printChar() method.
	 * 
	 * @param c
	 *            The char to repeat
	 * @param reps
	 *            The repetitions required
	 */
	public static void printBreakLine(char c, int reps) {
		printChar(c, reps);
	}

	/**
	 * Prints '-' x amount of times, where x is the first argument
	 * 
	 * @param reps
	 *            The repetitions required.
	 */
	public static void printBreakLine(int reps) {
		for (int ix = 0; ix < reps; ix++) {
			printChar('-', reps);
		}
	}

	/**
	 * This prints a char x amount of times, where x is the second parameter.
	 * 
	 * @param c
	 *            The char to repeat
	 * @param reps
	 *            The number of repetitions.
	 */
	public static void printChar(char c, int reps) {

		for (int ix = 0; ix < reps; ix++) {
			out.print(c);
		}

	}

	/**
	 * This menu uses an object's toString method to get the name and then
	 * prints the menu. This method does not accept null values passed on as
	 * arguments & will throw a NullPointerException if it detects a null
	 * argument.
	 * 
	 * @param objects
	 *            The array of objects to use.
	 */
	public static void printMenu(Object[] objects) {
		// A nice way of saving a little space.
		printMenu(PLArrays.findStrings(objects));
	}

	/**
	 * This calls the
	 * <code>printMenu(String[] items, String text, PrintType type)</code>
	 * method with the items being represented as an array of each object's
	 * toString method. This method does not accept null values passed on as
	 * arguments & will throw a NullPointerException if it detects a null
	 * argument.
	 * 
	 * @param objects
	 *            The objects to use in the menu.
	 * @param text
	 *            The introduction or ending text.
	 * @param type
	 *            The type of the text string. Is it a prefix or a suffix?
	 */
	public static void printMenu(Object[] objects, String text, PrintType type) {
		printMenu(PLArrays.findStrings(objects), text, type);
	}

	/**
	 * This prints a menu with a given set of items to print. This method does
	 * not accept null values passed on as arguments & will throw a
	 * NullPointerException if it detects a null argument.
	 * 
	 * @param items
	 *            An array of text that will be printed.
	 */
	public static void printMenu(String[] items) {
		// Checks to make sure you don't pass in null values.
		if (items != null) {
			// Prints out the list of items.
			for (int ix = 0; ix < items.length; ix++) {
				out.println(ix + ") " + items[ix]);
			}

		} else {
			// Throws an error if you pass on a null value.
			throw new NullPointerException("Passed null for the list of items");
		}
	}

	/**
	 * This method prints a rather customizable menu. It takes two parameters,
	 * the items to list & the preceding or ending text. Use "@NUM@" to signify
	 * that you mean the iteration, like "1, [info]" is actually "@NUM@, [info]"
	 * in the item string. Note that the 3rd string will have the number 3 even
	 * if the 2nd string lacks a number. This method does not accept null values
	 * passed on as arguments & will throw a NullPointerException if it detects
	 * a null argument.
	 * 
	 * @param items
	 *            The items to use in the menu.
	 * @param text
	 *            The introduction or ending text.
	 * @param type
	 *            The type of the text string. Is it a prefix or a suffix?
	 */
	public static void printMenu(String[] items, String text, PrintType type) {
		if (items != null && text != null && type != null) {

			if (type == PrintType.HEADER) {
				for (int ix = 0; ix < items.length; ix++) {
					out.println(text.replaceAll("@NUM@",
							Integer.toString(ix + 1))
							+ items[ix]);
				}
			} else if (type == PrintType.FOOTNOTE) {
				for (int ix = 0; ix < items.length; ix++) {
					out.println(items[ix]
							+ text.replaceAll("@NUM@", Integer.toString(ix + 1)));
				}
			}

		} else {
			throw new NullPointerException(
					(items == null) ? "Passed null for the list of items"
							: (text == null) ? "Passed null for the prefix/suffix"
									: "Passed null for the type of text to print with the footnote/header");
		}

	}

}