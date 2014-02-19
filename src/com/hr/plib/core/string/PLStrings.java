package com.hr.plib.core.string;

import static java.lang.String.valueOf;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class deals with methods that are directly related to strings.
 * 
 * @author Harshavardhan Ramesh - Sep 22, 2013
 */
public class PLStrings {

	/**
	 * This is the value for the character 'a' in ASCII.
	 */
	public static final int LOWER_CASE_ASCII_BEGIN = 97;

	/**
	 * This is the value for the character 'z' in ASCII.
	 */
	public static final int LOWER_CASE_ASCII_END = 122;

	/**
	 * This is the value for the character 'A' in ASCII.
	 */
	public static final int UPPER_CASE_ASCII_BEGIN = 65;

	/**
	 * This is the value for the character 'Z' in ASCII.
	 */
	public static final int UPPER_CASE_ASCII_END = 90;

	/**
	 * This is the value for a space in ASCII.
	 */
	public static final int ASCII_SPACE = 32;

	/**
	 * This method adds a single character to a string. Why you would prefer
	 * this to String string += char c, is beyond me. But anyways, voilà!
	 * 
	 * @param string
	 *            The string to add the character to.
	 * @param c
	 *            The character to add.
	 * @return The string plus the character.
	 */
	public static String addChar(String string, char c) {
		// Adds a char & then returns.
		return string += c;
	}

	/**
	 * This method adds an array of characters to a string. Effectively a simple
	 * iterative loop that adds things to a string & then returns the new
	 * string.
	 * 
	 * @param string
	 *            The string to add to.
	 * @param c
	 *            The characters to add.
	 * @return The string plus all of the characters.
	 */
	public static String addChar(String string, char[] c) {
		// Adds the character array to the string.
		return new StringBuilder(string).append(c).toString();
	}

	/**
	 * This method gets the number of letters that are in a string.
	 * 
	 * @param string
	 *            The string to analyze.
	 * @return The number of letters in the string.
	 */
	public static long getLetterCount(String string) {
		// Declares a variable to store the number of letters.
		long letterCount = 0;
		// Looks for each character & checks if it is a letter.
		for (char c : string.toCharArray()) {
			letterCount += ((c >= LOWER_CASE_ASCII_BEGIN && c <= LOWER_CASE_ASCII_END) || (c >= UPPER_CASE_ASCII_BEGIN && c <= UPPER_CASE_ASCII_END)) ? 1
					: 0;
		}
		// Returns the number of letters.
		return letterCount;
	}

	/**
	 * This method gets the number of spaces in a string.
	 * 
	 * @param string
	 *            The string to analyze.
	 * @return The number of spaces.
	 */
	public static long getSpaceCount(String string) {
		// Declares a variable to store the number of spaces.
		long spaceCount = 0;
		// Looks for each space.
		for (char c : string.toCharArray()) {
			spaceCount += (Character.isWhitespace(c)) ? 1 : 0;
		}
		// Returns the number of spaces
		return spaceCount;
	}

	/**
	 * This method gets the number of symbols. A symbol is characterized as not
	 * being a letter and not being a number or a space.
	 * 
	 * @param string
	 *            The string to analyze.
	 * @return The number of symbols.
	 */
	public static long getSymbolCount(String string) {
		// Declares a variable to store the number of symbols.
		long symbolCount = 0;
		// Looks for each symbol in an array.
		for (char c : string.toCharArray()) {
			symbolCount += (Character.isLetterOrDigit(c) || Character
					.isWhitespace(c)) ? 0 : 1;
		}
		// Returns the number of symbols.
		return symbolCount;
	}

	/**
	 * This method gets some info on a string. Returns an array with the number
	 * of upper case letters followed by the number of lower case letters
	 * followed by the number of spaces followed by the number of digits
	 * followed by the number of symbols followed by the number of symbols.
	 * 
	 * @param string
	 *            The string to analyze.
	 * @return Upper Case : Lower Case : Spaces : Digits : Symbols
	 */
	public static long[] getTypes(String string) {
		// Declares a variable to store the number of capital letters.
		long counts[] = { 0, 0, 0, 0, 0 };
		// Looks for the capital letters.
		for (char c : string.toCharArray()) {

			if (c >= UPPER_CASE_ASCII_BEGIN && c <= UPPER_CASE_ASCII_END) {
				counts[0]++;
			} else if (c >= LOWER_CASE_ASCII_BEGIN && c <= LOWER_CASE_ASCII_END) {
				counts[1]++;
			} else if (Character.isWhitespace(c)) {
				counts[2]++;
			} else if (Character.isDigit(c)) {
				counts[3]++;
			} else {
				counts[4]++;
			}
		}
		// Returns the number of capital letters.
		return counts;
	}

	/**
	 * This method gets the number of words in a string. It only accepts words
	 * that are at least 2 letters long & include at least 1 letter. Note that
	 * this does not use a dictionary, but rather just counts the number of
	 * spaces to give an estimate of how many words are in a string. This may
	 * have a large degree of error when parsing huge strings.
	 * 
	 * @param string
	 *            The string used.
	 * @return The number of words in the string.
	 */
	public static long getWordCount(String string) {
		// The variable to hold the number of words.
		long wordCount = 0;
		// This string gets each word.
		String[] pString = string.trim().split(" ");
		// Goes through each word
		for (String s : pString) {
			// The location of the character in the string we are currently
			// looking at.
			int charLocation = 0;
			// This is whether or not we have added this string yet.
			boolean canQuit = false;
			// Goes through each letter to make sure that it is really a word.
			while (charLocation < ((s.length() > 1 || s.equals("a") || s
					.equals("I")) ? s.length() : 0) && !canQuit) {
				if (Character.isLetter(s.charAt(charLocation))) {
					wordCount++;
					canQuit = true;
				}
				charLocation++;
			}
		}
		// Returns the number of words.
		return wordCount;
	}

	/**
	 * This determines if a string is palindromic or not, or that it is
	 * Symmetrical.
	 * 
	 * @param s
	 *            - The string given.
	 * @return True if this is palindromic, else false.
	 */
	public boolean isPalindromic(String s) {
		if (s == null)
			throw new NullPointerException("String cannot be null!");
		for (int ix = 0; ix < s.length() / 2; ix++) {
			if (s.charAt(ix) != s.charAt(s.length() - (ix + 1)))
				return false;
		}
		return true;
	}

	/**
	 * This prints all of the permutations of a given string.
	 * 
	 * @param string
	 *            - The string to permute.
	 * @return An array with all possible permutations of the same length;
	 */
	public static String[] permutations(String string) {
		if (null == string || string.isEmpty())
			return null;

		List<String> permutations = new LinkedList<>();
		permutations.add(valueOf(string.charAt(0)));

		List<String> words = new LinkedList<>();

		for (int ix = 1; ix < string.length(); ix++) {

			for (int iy = 0; iy < permutations.size(); iy++) {
				words.addAll(merge(string.charAt(ix), permutations.get(iy)));
			}

			permutations.clear();
			permutations.addAll(words);

			words.clear();

		}

		return permutations.toArray(new String[permutations.size()]);
	}

	/**
	 * Helper method that appends the given character at each position in the
	 * given string and returns a set of such modified strings - set removes
	 * duplicates if any(in case a character is repeated)
	 */
	private static Set<String> merge(Character c, String s) {
		if (s == null || s.isEmpty()) {
			return null;
		}

		int len = s.length();
		StringBuilder sb = new StringBuilder();
		Set<String> list = new HashSet<String>();

		for (int i = 0; i <= len; i++) {
			sb = new StringBuilder();
			sb.append(s.substring(0, i) + c + s.substring(i, len));
			list.add(sb.toString());
		}

		return list;
	}

}