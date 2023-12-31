package DataStructure;

import java.util.ArrayList;

public class PangramString {
	/*
	 * missing char in panagram
	 */
	private static ArrayList<Character> missingChars(String str, int strLength) {
		final int MAX_CHARS = 26;

		// A boolean array to store characters
		// present in string.
		boolean[] present = new boolean[MAX_CHARS];
		ArrayList<Character> charsList = new ArrayList<>();

		// Traverse string and mark characters
		// present in string.
		for (int i = 0; i < strLength; i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				present[str.charAt(i) - 'A'] = true;
			else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
				present[str.charAt(i) - 'a'] = true;
		}

		// Store missing characters in alphabetic
		// order.
		for (int i = 0; i < MAX_CHARS; i++) {
			if (present[i] == false)
				charsList.add((char) (i + 'a'));
		}
		return charsList;
	}

	public static void main(String[] args) {

		String str1 = "The quick brown fox jumps " + "over the dog";
		String str = "qwqqwqeqqwdsdadsdasadsfsdsdsdasasas";

		ArrayList<Character> missing = PangramString.missingChars(str, str.length());

		int count=0;
		if (missing.size() >= 1) {
			for (Character character : missing) {
				System.out.print(character);
				count++;
			}
			System.out.println( );
			System.out.println();
		}
		
	}
}
