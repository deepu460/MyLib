package com.hr.plib.core.math;

import static java.lang.Math.random;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class has some math functions that can be useful at times.
 * 
 * @author Harshavardhan Ramesh - Sep 24, 2013
 */
public class PLMath {

	/**
	 * This returns a random boolean.
	 * 
	 * @return Either true or false with a 50% chance of each.
	 */
	public static boolean randBool() {
		return random() < 0.5 ? true : false;
	}

	/**
	 * This method generates a random double.
	 * 
	 * @param min
	 *            The minimum value.
	 * @param max
	 *            The maximum value.
	 * @return A random double.
	 */
	public static double randDouble(long min, long max) {
		return min + (double) (random() * ((max - min) + 1));
	}

	/**
	 * This method generates a random integer in a given range.
	 * 
	 * @param min
	 *            The minimum value.
	 * @param max
	 *            The maximum value.
	 * @return A random integer.
	 */
	public static int randInt(int min, int max) {
		return min + (int) (random() * ((max - min) + 1));
	}

	/**
	 * This method generates a random long in a given range.
	 * 
	 * @param min
	 *            The minimum value.
	 * @param max
	 *            The maximum value.
	 * @return A random long.
	 */
	public static long randLong(long min, long max) {
		return min + (long) (random() * ((max - min) + 1));
	}

	/**
	 * This converts any object into a byte array containing the info about this
	 * object.
	 * 
	 * @param obj
	 *            - The object.
	 * @return The object represented as a byte array.
	 * @throws IOException
	 *             - If an I/O error occurs while writing stream header
	 */
	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os;
		os = new ObjectOutputStream(out);
		os.writeObject(obj);
		return out.toByteArray();
	}

	/**
	 * This converts a byte array into an object.
	 * 
	 * @param data
	 *            - The byte array.
	 * @return The object represented by the data.
	 * @throws IOException
	 *             - If an I/O error occurs while writing stream header
	 * @throws ClassNotFoundException
	 *             - Class of a serialized object cannot be found.
	 */
	public static Object deserialize(byte[] data) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);
		return is.readObject();
	}

	/**
	 * This gets the distance between two points using vector math.
	 * 
	 * @param x1
	 *            - The first x.
	 * @param y1
	 *            - The first y.
	 * @param x2
	 *            - The second x.
	 * @param y2
	 *            - The second y.
	 * @return The distance between (x1,y1) & (x2,y2).
	 */
	public static double distance(double x1, double y1, double x2, double y2) {
		return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
	}

}