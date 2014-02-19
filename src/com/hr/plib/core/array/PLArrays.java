package com.hr.plib.core.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.plib.core.string.PLRandStrings;

/**
 * This is the personal library's array methods. These methods are related to an
 * array in some form or fashion.
 * 
 * @author Harshavardhan Ramesh - Sep 18, 2013
 */
public final class PLArrays {

	/**
	 * This method concatenates 2 arrays together.
	 * 
	 * @param first
	 *            The first array.
	 * @param second
	 *            The second array.
	 * @return An array which is the first concatenating the second. Returns any
	 *         non-null variable if given one null value and null if both arrays
	 *         are null.
	 */
	public static <T> T[] concat(T[] first, T[] second) {
		// Error checking.
		if (first == null) {
			if (second == null)
				return null;
			return second;
		} else if (second == null)
			return first;
		// Copies the first array.
		T[] result = Arrays.copyOf(first, first.length + second.length);
		// Copies again.
		System.arraycopy(second, 0, result, first.length, second.length);
		// Returns the result of this.
		return result;
	}

	/**
	 * This concatenates 2 arbitrary number arrays with a length greater than 1.
	 * 
	 * @param first
	 *            The first array.
	 * @param rest
	 *            The second array.
	 * @return An array of both. Returns null if any null arguments are passed
	 *         on to this method.
	 */
	@SafeVarargs
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		if (first == null || rest == null)
			return null;
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	/**
	 * This is effectively the same thing as
	 * <code>findStrings(objects, 100)</code>. Useful for saving time.
	 * 
	 * @param objects
	 *            The array to convert.
	 * 
	 * @return An array of the object's toString() methods.
	 */
	public static String[] findStrings(Object[] objects) {
		return findStrings(objects, 100);
	}

	/**
	 * This method converts any array into an array of strings by iteratively
	 * calling each object's toString method. It uses an ArrayList with a set
	 * size. The size defaults to zero should the initialCapacity be invalid.
	 * 
	 * @param objects
	 *            The array to covert.
	 * @param initialCapacity
	 *            The initial capacity of the ArrayList. If it is less than 1,
	 *            then it will be set to 100.
	 * @return An array of the object array's <code>toString()</code> methods.
	 */
	public static String[] findStrings(Object[] objects, int intitalCapacity) {
		// Makes an array of strings, and initializes it to a real value.
		ArrayList<String> strings = new ArrayList<String>(
				(intitalCapacity > 0) ? intitalCapacity : 100);
		// Goes through each object and add's its toString result.
		for (int ix = 0; ix < objects.length; ix++) {
			strings.add(objects[ix].toString());
		}
		// Returns the strings as an array.
		return strings.toArray(new String[strings.size()]);
	}

	/**
	 * This generates a completely random set of strings with no limits on
	 * character size.
	 * 
	 * @param lengthOfStrings
	 *            The length of each string.
	 * @param sizeOfArray
	 *            The size of the array to make.
	 * @return An array of a certain size with a certain length.
	 */
	public static String[] genRandStrings(int lengthOfStrings, int sizeOfArray) {
		// An array of a set size
		String[] array = new String[sizeOfArray];
		// Here we add random strings
		for (int ix = 0; ix < array.length; ix++) {
			array[ix] = PLRandStrings.randString(0, 255, lengthOfStrings);
		}
		// Return the array.
		return array;
	}

	/**
	 * This method nullifies an array and sets all of it's values to null.
	 * 
	 * @param array
	 *            The array to nullify.
	 * @return An empty array or null if the array is null.
	 */
	public static <T> T[] nullifyArray(T[] array) {
		if (array == null)
			return null;
		for (int ix = 0; ix < array.length; ix++) {
			array[ix] = null;
		}
		return array;
	}

	/**
	 * Reallocates an array with a new size, and copies the contents of the old
	 * array to the new array.
	 * 
	 * @param oldArray
	 *            The old array, to be reallocated.
	 * @param newSize
	 *            The new array size.
	 * @return A new array with the same contents.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T resizeArray(T oldArray, int newSize) {
		int oldSize = Array.getLength(oldArray);
		Class<? extends Object> elementType = oldArray.getClass()
				.getComponentType();
		Object newArray = Array.newInstance(elementType, newSize);
		int preserveLength = Math.min(oldSize, newSize);

		if (preserveLength > 0)
			System.arraycopy(oldArray, 0, newArray, 0, preserveLength);

		return (T) newArray;
	}

	/**
	 * This converts any list to an array of itself.
	 * 
	 * @param list
	 *            The list of objects.
	 * @return An array of that list.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(T... list) {
		if (list == null)
			return null;
		List<T> array = new ArrayList<>();

		for (int ix = 0; ix < list.length; ix++) {
			array.add(list[ix]);
		}

		return (T[]) array.toArray();
	}

	/**
	 * This returns a generic representation of a 1-D boolean array.
	 * 
	 * @param array
	 *            The boolean array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(boolean[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D boolean array.
	 * 
	 * @param array
	 *            The boolean array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(boolean[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (boolean[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D byte array.
	 * 
	 * @param array
	 *            The byte array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(byte[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D byte array.
	 * 
	 * @param array
	 *            The byte array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(byte[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (byte[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D char array.
	 * 
	 * @param array
	 *            The char array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(char[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D char array.
	 * 
	 * @param array
	 *            The char array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(char[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (char[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D double array.
	 * 
	 * @param array
	 *            The double array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(double[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D double array.
	 * 
	 * @param array
	 *            The double array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(double[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (double[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D float array.
	 * 
	 * @param array
	 *            The float array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(float[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D float array.
	 * 
	 * @param array
	 *            The float array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(float[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (float[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D integer array.
	 * 
	 * @param array
	 *            The integer array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(int[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D integer array.
	 * 
	 * @param array
	 *            The integer array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(int[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (int[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D long array.
	 * 
	 * @param array
	 *            The long array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(long[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D long array.
	 * 
	 * @param array
	 *            The long array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(long[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (long[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 1-D short array.
	 * 
	 * @param array
	 *            The short array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(short[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a generic representation of a 2-D short array.
	 * 
	 * @param array
	 *            The short array to represent.
	 * @return A string that represents the array's values.
	 */
	public static String toString(short[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (short[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a representation of a 1-D generic array.
	 * 
	 * @param array
	 *            The generic array to represent.
	 * @return A string that represents the array's values.
	 */
	public static <T> String toString(T[] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through each value and adds it the the StringBuilder.
		for (int x = 0; x < array.length; x++) {
			builder.append(array[x] + (x == array.length - 1 ? "" : " "));
		}
		// Returns the final string.
		return builder.toString();
	}

	/**
	 * This returns a representation of a 2-D generic array.
	 * 
	 * @param array
	 *            The generic array to represent.
	 * @return A string that represents the array's values.
	 */
	public static <T> String toString(T[][] array) {
		// Makes a StringBuilder to add the strings.
		StringBuilder builder = new StringBuilder();
		// Loops through and adds each array.
		for (T[] arr : array) {
			builder.append(toString(arr) + "\n");
		}
		// Returns the final string.
		return builder.toString();
	}

}