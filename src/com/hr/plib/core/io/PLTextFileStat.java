package com.hr.plib.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;

/**
 * This class stores some information about a text file. Rather than storing a
 * file itself, it will store information about the file along with it's path.
 * This is a more fluid form of a PLTextAnalyzer, as it stores the information
 * that can easily be adjustable.
 * 
 * @author Harshavardhan Ramesh - Oct 4, 2013
 */
public class PLTextFileStat {
	// TODO: Code the text file statistics

	/**
	 * The path of the file. This is optional, but recommended so that a new
	 * file can be made without having to resort to storing a list of file in
	 * memory.
	 */
	private String path;

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
	 * Generates a generic object to store some info. That's about all.
	 */
	public PLTextFileStat() {
		super();
	}

	/**
	 * Immediately gets info from a file and puts it into this data structure.
	 * 
	 * @param file
	 *            The file to analyze.
	 * @throws FileNotFoundException
	 */
	public PLTextFileStat(File file) throws FileNotFoundException {
		path = file.getAbsolutePath();
		PLTextAnalyzer analyzer = new PLTextAnalyzer(file);
		wordCount = analyzer.getWordCount();
		letterCount = analyzer.getLetterCount();
		characterCount = analyzer.getCharacterCount();
		symbolCount = analyzer.getSymbolCount();
		spaceCount = analyzer.getSpaceCount();
		capitalCount = analyzer.getCapitalCount();
		lowerCount = analyzer.getLowerCount();
		digitCount = analyzer.getDigitCount();
	}

	/**
	 * This sets up the data structure with everything but the system path.
	 * 
	 * @param wordCount
	 *            The number of words.
	 * @param letterCount
	 *            The number of letters.
	 * @param characterCount
	 *            The number of characters.
	 * @param symbolCount
	 *            The number of symbols.
	 * @param spaceCount
	 *            The number of spaces.
	 * @param capitalCount
	 *            The number of capital letters.
	 * @param lowerCount
	 *            The number of lower case letters.
	 * @param digitCount
	 *            The number of digits.
	 */
	public PLTextFileStat(long wordCount, long letterCount,
			long characterCount, long symbolCount, long spaceCount,
			long capitalCount, long lowerCount, long digitCount) {
		super();
		this.wordCount = wordCount;
		this.letterCount = letterCount;
		this.characterCount = characterCount;
		this.symbolCount = symbolCount;
		this.spaceCount = spaceCount;
		this.capitalCount = capitalCount;
		this.lowerCount = lowerCount;
		this.digitCount = digitCount;
	}

	/**
	 * Extracts info from a <code>PLTextAnalyzer</code>.
	 * 
	 * @param analyzer
	 *            The analyzer to extract info from.
	 */
	public PLTextFileStat(PLTextAnalyzer analyzer) {
		if (analyzer != null) {
			wordCount = analyzer.getWordCount();
			letterCount = analyzer.getLetterCount();
			characterCount = analyzer.getCharacterCount();
			symbolCount = analyzer.getSymbolCount();
			spaceCount = analyzer.getSpaceCount();
			capitalCount = analyzer.getCapitalCount();
			lowerCount = analyzer.getLowerCount();
			digitCount = analyzer.getDigitCount();
		} else {
			throw new InvalidParameterException("Null analyzer!");
		}
	}

	/**
	 * Same as the generic constructor, but adds a path for the file that may be
	 * read later.
	 * 
	 * @param path
	 *            The system path to the file.
	 */
	public PLTextFileStat(String path) {
		super();
		this.path = path;
	}

	/**
	 * This sets up the data structure with everything.
	 * 
	 * @param path
	 *            The system path.
	 * @param wordCount
	 *            The number of words.
	 * @param letterCount
	 *            The number of letters.
	 * @param characterCount
	 *            The number of characters.
	 * @param symbolCount
	 *            The number of symbols.
	 * @param spaceCount
	 *            The number of spaces.
	 * @param capitalCount
	 *            The number of capital letters.
	 * @param lowerCount
	 *            The number of lower case letters.
	 * @param digitCount
	 *            The number of digits.
	 */
	public PLTextFileStat(String path, long wordCount, long letterCount,
			long characterCount, long symbolCount, long spaceCount,
			long capitalCount, long lowerCount, long digitCount) {
		super();
		this.path = path;
		this.wordCount = wordCount;
		this.letterCount = letterCount;
		this.characterCount = characterCount;
		this.symbolCount = symbolCount;
		this.spaceCount = spaceCount;
		this.capitalCount = capitalCount;
		this.lowerCount = lowerCount;
		this.digitCount = digitCount;
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
	 * @return The path of the file of origin.
	 */
	public String getPath() {
		return path;
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
	 * @return true if this has a path, else false. Useful if you want to make
	 *         sure that you don't get a <code>NullPointerException</code>.
	 */
	public boolean hasPath() {
		return (path.length() == 0) ? false : true;
	}

	/**
	 * Sets the number of capital letters.
	 * 
	 * @param capitalCount
	 *            The number of capital letters to set to.
	 */
	public void setCapitalCount(long capitalCount) {
		this.capitalCount = capitalCount;
	}

	/**
	 * Sets the character count.
	 * 
	 * @param characterCount
	 *            The number of characters to set to.
	 */
	public void setCharacterCount(long characterCount) {
		this.characterCount = characterCount;
	}

	/**
	 * Sets the number of digits.
	 * 
	 * @param digitCount
	 *            The number of digits to set to.
	 */
	public void setDigitCount(long digitCount) {
		this.digitCount = digitCount;
	}

	/**
	 * Sets the letter count.
	 * 
	 * @param letterCount
	 *            The number of letters to set the variable to.
	 */
	public void setLetterCount(long letterCount) {
		this.letterCount = letterCount;
	}

	/**
	 * Sets the number of lower case letters.
	 * 
	 * @param lowerCount
	 *            The number of lower case letters to set to.
	 */
	public void setLowerCount(long lowerCount) {
		this.lowerCount = lowerCount;
	}

	/**
	 * This sets the path of the file.
	 * 
	 * @param path
	 *            The system path to the file.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the number of spaces.
	 * 
	 * @param spaceCount
	 *            The number of spaces to set to.
	 */
	public void setSpaceCount(long spaceCount) {
		this.spaceCount = spaceCount;
	}

	/**
	 * Sets the number of symbols.
	 * 
	 * @param symbolCount
	 *            The number of symbols to set to.
	 */
	public void setSymbolCount(long symbolCount) {
		this.symbolCount = symbolCount;
	}

	/**
	 * Sets the word count.
	 * 
	 * @param wordCount
	 *            The number of words to set the variable to.
	 */
	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

}