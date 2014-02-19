package com.hr.plib.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class has methods that deal directly with files.
 * 
 * @author Harshavardhan Ramesh - Sep 24, 2013
 */
public class PLFiles {

	/**
	 * This method gets the number of letters in a text file. This returns a
	 * long, as the number of letters may be rather high. This only parses the
	 * document one line at a time to conserve memory.
	 * 
	 * @param file
	 *            The file to parse.
	 * @return The number of letters.
	 */
	public static long getLetCount(File file) throws FileNotFoundException {
		// This variables stores the number of letters.
		long numOfLets = 0;
		// This scans the document.
		BufferedReader reader = null;
		// Initializes the reader.
		reader = new BufferedReader(new FileReader(file));
		// A temporary variable to store one line.
		String line;
		// Scans through the text file & counts the number of letters.
		try {
			while ((line = reader.readLine()) != null) {
				// Sorts these into words.
				line = line.replaceAll(" ", "");
				// Goes through each symbol to make sure it's a letter.
				for (int ix = 0; ix < line.length(); ix++) {
					numOfLets += ((line.charAt(ix) > 64 && line.charAt(ix) < 91) || (line
							.charAt(ix) > 96 && line.charAt(ix) < 123)) ? 1 : 0;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Closes the reader.
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Returns the number of letters.
		return numOfLets;
	}

	/**
	 * This gets the number of letters in a file.
	 * 
	 * @param file
	 *            The file to analyze.
	 * @return The number of files.
	 */
	public static int getLetters(File file) throws FileNotFoundException {
		// The scanner to search through the file.
		Scanner scanner;
		// Stores the number of letters.
		int numOfLet = 0;
		// Makes the scanner a valid object.
		scanner = new Scanner(file);
		// Adds the number of letters on each line.
		while (scanner.hasNext()) {
			numOfLet += scanner.nextLine().length();
		}
		// Closes the scanner.
		scanner.close();
		// Returns the number of letters.
		return numOfLet;

	}

	/**
	 * This finds the amount of words in a text file. It assumes that words are
	 * just letters with a " " separating them.
	 * 
	 * @param file
	 *            The file to read.
	 * 
	 * @return The amount of words in a file.
	 */
	public static long getWordCount(File file) throws FileNotFoundException {
		// This variable stores the number of words.
		long numOfWords = 0;
		// Temporary variable that stores the line.
		String line = "";
		// This scans the document.
		BufferedReader reader = new BufferedReader(new FileReader(file));
		// Scans through each line and adds the number of words in each line.
		try {
			while ((line = reader.readLine()) != null) {
				// Records how many words there are.
				numOfWords += line.split(" ").length;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Closes the reader
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Returns the word count.
		return numOfWords;
	}

	/**
	 * This loads all of the lines of text in a file. It is not recommended to
	 * do this with big files.
	 * 
	 * @param file
	 *            The file to load
	 * @return All of the line of the file in memory as an array of strings.
	 */
	public static String[] loadTextLines(File file)
			throws FileNotFoundException {
		// This is the text of the document.
		ArrayList<String> text = new ArrayList<>();
		// This reads in the document.
		Scanner scanner = null;
		// Initializes the scanner. Can throw a FileNoteFoundException.
		scanner = new Scanner(file);
		// Actually reads in each line of text.
		while (scanner.hasNext()) {
			text.add(scanner.nextLine());
		}
		// Closes the scanner.
		if (scanner != null)
			scanner.close();
		// Returns an array of what we just got.
		return text.toArray(new String[text.size()]);
	}

	/**
	 * This finds the most common letters.
	 * 
	 * @param file
	 *            The file to scan.
	 * @param amount
	 *            The amount of most common letters to add. For example, if you
	 *            enter 3, it will return the top three most common letters.
	 * @return A string array of the 3 most common letters.
	 */
	public static String[] mostCommonLet(File file, int amount)
			throws FileNotFoundException {
		// This holds an entire document.
		ArrayList<String> common;
		// This scans through the document.
		BufferedReader reader;
		// This holds a temporary variable
		String temp1;
		// This is the info of a line.
		String[] line;
		// The top letters.
		String[] top;
		// The top letter's amount.
		int[] topAmount;
		// The instances of a certain letter.
		int instances;
		// Returns null if you ask for too many letters.
		if (amount > 52)
			return null;
		// Initialization of the variables
		else {
			top = new String[amount];
			topAmount = new int[amount];
			common = new ArrayList<>();
			reader = null;
			instances = 0;
			line = new String[1];
		}
		// Makes the reader
		reader = new BufferedReader(new FileReader(file));
		// Makes the top amount values to zero.
		for (int ix = 0; ix < topAmount.length; ix++) {
			topAmount[ix] = 0;
		}
		/*
		 * What this does: While there is more, get the line & immediately split
		 * it based on spaces. Then, if it is a character, add the value of the
		 * character. This does seem to work quite well.
		 */
		try {
			while ((line[0] = reader.readLine()) != null) {
				line = line[0].split(" ");
				for (String string : line) {
					for (char c : string.toCharArray()) {
						if (c < 91 && c > 64 || c < 123 && c > 96) {
							common.add(String.valueOf(c));
						}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Sort the ArrayList.
		Collections.sort(common);
		// Get the organization set up.
		temp1 = common.get(0);
		// Compares each letter individually.
		for (String string : common) {
			// Adds more of a string if it is the same.
			if (temp1.equals(string)) {
				instances++;
			} else {
				// Checks if there is a change in the top letters.
				boolean change = false;

				for (int ix = 0; ix < topAmount.length; ix++) {
					if (instances > topAmount[ix]) {
						top[ix] = temp1;
						topAmount[ix] = instances;
						instances = 0;
						change = true;
						break;
					}
				}
				// If there's no change, set instances variable to 0.
				if (!change)
					instances = 0;
				// Goes to next line.
				temp1 = string;
			}
		}
		// Closes the reader.
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Returns the most common letters.
		return top;
	}

	/**
	 * This sorts a list text data.
	 * 
	 * @param text
	 *            The info to go through
	 * @param type
	 *            The way to sort the array.
	 * @return A sorted array.
	 */
	// TODO: Code the PLTextAnalyzer sorter method.
	public static PLTextFileStat[] sortPLTextAnalyzers(PLTextFileStat[] info,
			PLTextAnalyzer.Type type) {

		return null;
	}

}