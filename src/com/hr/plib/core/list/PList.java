package com.hr.plib.core.list;

import static java.lang.Byte.valueOf;
import static java.lang.Double.valueOf;
import static java.lang.Integer.valueOf;
import static java.lang.Long.valueOf;
import static java.lang.Short.valueOf;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * These are some methods that are meant to enhance list functionality.
 * 
 * @author Harshavardhan Ramesh - Feb 11, 2014
 */
public class PList {

	/**
	 * This converts any generic array to a list.
	 * 
	 * @param array
	 *            - The generic array.
	 * @return A list with all of the elements of the array.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<T> asList(T[] array) {
		return subList(array, 0);
	}

	/**
	 * This converts any generic 2D array to a list.
	 * 
	 * @param array
	 *            - The generic array.
	 * @return A list with all of the elements of the array.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<List<T>> asList(T[][] array) {
		return subList(array, 0);
	}

	/**
	 * This converts part of a generic array to a list.
	 * 
	 * @param array
	 *            - The generic array.
	 * @param start
	 *            - The start index.
	 * @param end
	 *            - The end index.
	 * @return A list containing all of the specified elements of the array.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<T> subList(T[] array, int start, int end) {
		// Error checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		// Makes a list.
		List<T> list = new ArrayList<>(end - start);
		// Adds the array's content.
		for (int ix = start; ix < end; ix++) {
			list.add(array[ix]);
		}
		// Returns the list.
		return list;
	}

	/**
	 * This converts part of a generic array to a list. This only takes the
	 * beginning and continues on to the end of the array.
	 * 
	 * @param array
	 *            - The generic array.
	 * @param start
	 *            - The start index.
	 * @return A list containing all of the specified elements of the array.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<T> subList(T[] array, int start) {
		return subList(array, start, array.length);
	}

	/**
	 * This converts any 2D generic array into a list of lists.
	 * 
	 * @param array
	 *            - The 2D array
	 * @param start
	 *            - The start index.
	 * @param end
	 *            - The end index.
	 * @return A list containing all of the specified elements of the arrays.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<List<T>> subList(T[][] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		// Makes a list.
		List<List<T>> list = new ArrayList<>(end - start);
		// Adds the array's content.
		for (int ix = start; ix < end; ix++) {
			list.add(asList(array[ix]));
		}
		// Returns the list.
		return list;
	}

	/**
	 * This converts any 2D generic array into a list of lists.
	 * 
	 * @param array
	 *            - The 2D array
	 * @param start
	 *            - The start index.
	 * @param end
	 *            - The end index.
	 * @return A list containing all of the specified elements of the arrays.
	 * @throws NullPointerException
	 *             - If the array is null.
	 * @throws InvalidParameterException
	 *             - If start or end is invalid.
	 */
	public static <T> List<List<T>> subList(T[][] array, int start) {
		return subList(array, start, array.length);
	}

	public static List<Double> subList(double[] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		List<Double> list = new ArrayList<>(array.length);

		for (double d : array) {
			list.add(valueOf(d));
		}

		return list;
	}

	public static List<Long> subList(long[] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		List<Long> list = new ArrayList<>(array.length);

		for (long l : array) {
			list.add(valueOf(l));
		}

		return list;
	}

	public static List<Integer> subList(int[] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		List<Integer> list = new ArrayList<>(array.length);

		for (int i : array) {
			list.add(valueOf(i));
		}

		return list;
	}

	public static List<Short> subList(short[] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		List<Short> list = new ArrayList<>(array.length);

		for (short i : array) {
			list.add(valueOf(i));
		}

		return list;
	}

	public static List<Byte> subList(byte[] array, int start, int end) {
		// Error Checking.
		if (array == null)
			throw new NullPointerException("Array cannot be null!");
		else if (start < 0 || start > array.length || end < 0
				|| end > array.length || start > end)
			throw new InvalidParameterException("Invalid start or end!");
		List<Byte> list = new ArrayList<>(array.length);

		for (byte i : array) {
			list.add(valueOf(i));
		}

		return list;
	}

}