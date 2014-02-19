package com.hr.plib.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.hr.plib.core.string.PLStrings;

/**
 * This class analyzes a text file and can print out statistics about it. This
 * implements the <code>Comparable</code> interface such that it can be sorted
 * base on various types.
 * 
 * @author Harshavardhan Ramesh - Sep 22, 2013
 */
public class PLTextAnalyzer implements Comparable<PLTextAnalyzer> {
	/**
	 * These are the type of ways that we can sort these classes.
	 */
	public static enum Type {
		WORD, LETTER, CHARACTER, SYMBOL, NUMBER, SPACE, CAPITAL, LOWER;
	}

	// Sets up any global library variables.
	static {
		sortingBy = Type.WORD;
	}

	/**
	 * This is the variable that the <code>PLFiles</code> class will use to sort
	 * the files. By default it is set to <code>Type.WORD</code>
	 */
	private static Type sortingBy;

	/**
	 * Sets the type of variable to sort by. It accepts anything that is in the
	 * <code>PLTextAnalyzer.Type</code> class. Is set at default to
	 * <code>Type.WORD</code>.
	 * 
	 * @param type
	 *            The type of variable to sort by.
	 */
	public static void setType(Type type) {
		sortingBy = type;
	}

	/**
	 * This is how the text file is read and understood. Used for file I/O.
	 */
	private Scanner reader;

	/**
	 * This is the number of words in a text file.
	 */
	private long wordCount;

	/**
	 * This is the number of letters in a text file.
	 */
	private long letterCount;

	/**
	 * This is the number of characters in a text file.
	 */
	private long characterCount;

	/**
	 * This is the number of symbols in a text file.
	 */
	private long symbolCount;

	/**
	 * This is the number of spaces in a text file.
	 */
	private long spaceCount;

	/**
	 * This is the number of capital letters in a text file.
	 */
	private long capitalCount;

	/**
	 * This is the number of lower case letters in a text file.
	 */
	private long lowerCount;

	/**
	 * This is the number of digits in a text file.
	 */
	private long digitCount;

	/**
	 * This immediately gets all of the info about a File as soon as it has been
	 * acquired. This may cause issues with a limits on memory. All variables
	 * have a default value of 0.
	 * 
	 * @param file
	 *            The file to analyze
	 * @throws FileNotFoundException
	 */
	public PLTextAnalyzer(File file) throws FileNotFoundException {
		super(); // Initiates any object values.
		wordCount = 0; // Initiates the word count to 0.
		letterCount = 0; // Initiates the letter count to 0.
		characterCount = 0; // Initiates the character count to 0.
		symbolCount = 0; // Initiates the symbol count to 0.
		spaceCount = 0; // Initiates the space count to 0.
		capitalCount = 0; // Initiates the capital letter count to 0.
		lowerCount = 0; // Initiates the lower case letter count to 0.
		digitCount = 0; // Initiates the digit count to 0.
		getInfo(file); // Gets info about the file.
	}

	public PLTextAnalyzer(String filePath) throws FileNotFoundException {
		super(); // Initiates any object values.
		wordCount = 0; // Initiates the word count to 0.
		letterCount = 0; // Initiates the letter count to 0.
		characterCount = 0; // Initiates the character count to 0.
		symbolCount = 0; // Initiates the symbol count to 0.
		spaceCount = 0; // Initiates the space count to 0.
		capitalCount = 0; // Initiates the capital letter count to 0.
		lowerCount = 0; // Initiates the lower case letter count to 0.
		digitCount = 0; // Initiates the digit count to 0.
		getInfo(new File(filePath)); // Gets info about the file.
	}

	/**
	 * This compares multiple <code>PLTextAnalyzer</code> classes.
	 * 
	 * @param o
	 *            The class to compare to.
	 */
	@Override
	public int compareTo(PLTextAnalyzer o) {
		// Goes through all of the possible values.

		if (sortingBy.compareTo(Type.WORD) == 0) {

		} else if (sortingBy.compareTo(Type.CAPITAL) == 0) {

		}

		switch (sortingBy) {
		// Sort by word count.
		case WORD:
			return Long.valueOf(wordCount).compareTo(
					Long.valueOf(o.getWordCount()));
			// Sort by capital letter count.
		case CAPITAL:
			return Long.valueOf(capitalCount).compareTo(
					Long.valueOf(o.getWordCount()));
			// Sort by character count.
		case CHARACTER:
			return Long.valueOf(characterCount).compareTo(
					Long.valueOf(o.getCharacterCount()));
			// Sort by letter count.
		case LETTER:
			return Long.valueOf(letterCount).compareTo(
					Long.valueOf(o.getLetterCount()));
			// Sort by lower case letter count.
		case LOWER:
			return Long.valueOf(lowerCount).compareTo(
					Long.valueOf(o.getLetterCount()));
			// Sort by digit count.
		case NUMBER:
			return Long.valueOf(digitCount).compareTo(
					Long.valueOf(o.getDigitCount()));
			// Sort by space count.
		case SPACE:
			return Long.valueOf(spaceCount).compareTo(
					Long.valueOf(o.getSpaceCount()));
			// Sort by symbol count.
		case SYMBOL:
			return Long.valueOf(symbolCount).compareTo(
					Long.valueOf(o.getSymbolCount()));
			// A default in-case something goes wrong.
		default:
			// Sorts by words by default.
			return Long.valueOf(wordCount).compareTo(
					Long.valueOf(o.getWordCount()));
		}
	}

	/**
	 * @return The number of capital letters.
	 */
	public long getCapitalCount() {
		return capitalCount;
	}

	/**
	 * @return The number of characters.
	 */
	public long getCharacterCount() {
		return characterCount;
	}

	/**
	 * @return The number of digits.
	 */
	public long getDigitCount() {
		return digitCount;
	}

	/**
	 * This method gets all of the info about a text file and stores it in
	 * memory.
	 * 
	 * @param file
	 *            The file to analyze.
	 * @throws FileNotFoundException
	 */
	private void getInfo(File file) throws FileNotFoundException {
		// Makes the reader point to the file.
		reader = new Scanner(file);
		// Loops through the document
		while (reader.hasNext()) {
			// Gets the line.
			String line = reader.nextLine();
			// Gets some info about the line.
			long[] temp = PLStrings.getTypes(line);
			// Adds this info to the master variables.
			wordCount += PLStrings.getWordCount(line);
			letterCount += temp[0] + temp[1];
			characterCount += line.length();
			symbolCount += temp[4];
			spaceCount += temp[2];
			capitalCount += temp[0];
			lowerCount += temp[1];
			digitCount += temp[3];
		}
		// Finished getting this info.
	}

	/**
	 * @return The number of letters.
	 */
	public long getLetterCount() {
		return letterCount;
	}

	/**
	 * @return The number of lower case letters.
	 */
	public long getLowerCount() {
		return lowerCount;
	}

	/**
	 * @return The number of spaces.
	 */
	public long getSpaceCount() {
		return spaceCount;
	}

	/**
	 * @return The number of symbols.
	 */
	public long getSymbolCount() {
		return symbolCount;
	}

	/**
	 * @return The number of words.
	 */
	public long getWordCount() {
		return wordCount;
	}

	/**
	 * Sets the file to look at. Causes it to get the info at this method's
	 * execution.
	 * 
	 * @param file
	 *            The file to analyze.
	 * @throws FileNotFoundException
	 */
	public void setFile(File file) throws FileNotFoundException {
		getInfo(file); // Pretty much resets the PLTextAnalyzer.
	}

	/**
	 * This returns a table format of this PLTextAnalyzer. It looks neat, and it
	 * can be overrided to change the format of the text.
	 * 
	 * @return A string representation of this file's statistics in a table
	 *         format.
	 */
	public String toTable() {
		// TODO: Code the toTable() method in the PLTextAnalyzer class.
		return null;
	}
}