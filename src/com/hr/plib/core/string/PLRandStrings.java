package com.hr.plib.core.string;

import java.security.InvalidParameterException;

import com.hr.plib.core.math.PLMath;

/**
 * These are the personal library's random string methods. These are useful for
 * making a customizable yet completely random string or string sequence using
 * the <code>PLArray.genRandStrings()</code> method.
 * 
 * @author Harshavardhan Ramesh - Sep 19, 2013
 */
public class PLRandStrings {
	/**
	 * This generates a completely random character between a minimum and a
	 * maximum. This method also checks to make sure you entered in valid values
	 * for the random character method.
	 * 
	 * @param min
	 *            The minimum ASCII value.
	 * @param max
	 *            The maximum ASCII value
	 * @return A random character.
	 */
	public static char randChar(int min, int max) {
		if (min > -1 && min < max && max < 256)
			return (char) PLMath.randInt(min, max);
		throw new InvalidParameterException("Min / Max is invalid!");
	}

	/**
	 * This makes a random string of a certain length between the ASCII values
	 * of 32 & 126.
	 * 
	 * @param lengthOfString
	 *            The length of the string.
	 * @return A random string.
	 */
	public static String randString(int lengthOfString) {
		return randString(32, 126, lengthOfString);
	}

	/**
	 * This generates a random string between a minimum & a maximum value.
	 * 
	 * @param min
	 *            The minimum ASCII value.
	 * @param max
	 *            The maximum ASCII value.
	 * @param lengthOfString
	 *            The length of the string.
	 * @return A random string of a length x with ASCII characters between a & b
	 *         with x being the length of the string, a being the minimum, & b
	 *         being the maximum.
	 */
	public static String randString(int min, int max, int lengthOfString) {
		return randString(new int[] { min, max }, lengthOfString);
	}

	/**
	 * This method generates a random string with an array of maximums and
	 * minimums. It must be even so that it will make a string.
	 * <p>
	 * The integer array is a bunch of sets of 2 numbers, like
	 * <code>int[] stringRanges = {1, 2, 5, 6}</code>. This will generate a
	 * string with chars of ASCII values between either 1 & 2 or 5 & 6.
	 * </p>
	 * 
	 * @param stringRanges
	 *            The ranges that this string can have.
	 * @param lengthOfString
	 *            The size of the string.
	 * @return A randomly generated string.
	 */
	public static String randString(int[] stringRanges, int lengthOfString) {
		// Make a string to hold the random string.
		StringBuilder sequence = new StringBuilder(lengthOfString);
		// Checks to make sure that the range of the string is not null.
		if (stringRanges == null)
			// Throws an exception if it is.
			throw new NullPointerException("Passed null for the string ranges.");
		else if (lengthOfString < 1)
			// Returns null if the length is unrealistic.
			return null;
		else {
			/*
			 * Checks to make sure that the string ranges is even, so that we
			 * can actually use this.
			 */
			// Checks if the number is even.
			if (stringRanges.length % 2 != 0)
				return null;

			// Checks to make sure that you entered in valid numbers.
			for (int ix = 0; ix < stringRanges.length; ix += 2) {
				// If the first # > second #, then return null.
				if (stringRanges[ix] > stringRanges[ix + 1]
						|| stringRanges[ix] < 0 || stringRanges[ix] > 245
						|| stringRanges[ix + 1] < 0
						|| stringRanges[ix + 1] > 245
						|| stringRanges[ix] == stringRanges[ix + 1])
					return null;
			}

			// Loops through and adds random chars
			for (int ix = 0; ix < lengthOfString; ix++) {
				// Equation for getting a random position in the string
				// range
				int range = PLMath.randInt(1, stringRanges.length / 2) - 1;
				// Adds the random character
				sequence.append(randChar(stringRanges[range * 2],
						stringRanges[range * 2 + 1]));
			}
		}
		// Returns the random string.
		return sequence.toString();
	}
}