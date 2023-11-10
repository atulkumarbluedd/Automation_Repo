package practiceProjectcoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReverseString {

	public static void reverseWordInMyString(String str) {
		/*
		 * The split() method of String class splits a string in several strings based
		 * on the delimiter passed as an argument to it
		 */
		String[] words = str.split(" ");
		String reversedString = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				/*
				 * The charAt() function returns the character at the given position in a string
				 */
				reverseWord = reverseWord + word.charAt(j);
			}
			reversedString = reversedString + reverseWord + " ";
		}
		System.out.println(str);
		System.out.println(reversedString);
	}

	static void reversesecond(String input) {
		char[] temparray = input.toCharArray();
		int left, right = 0;
		right = temparray.length - 1;

		for (left = 0; left < right; left++, right--) {
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right] = temp;
		}

		for (char c : temparray)
			System.out.print(c);
		System.out.println();
	}

	static void reverseThird(String input) {
		System.out.println("<--------using array List ----->");

		char[] r = input.toCharArray();

		List<Character> trial1 = new ArrayList<>();
		for (char c : r)
			trial1.add(c);

		Collections.reverse(trial1);
		ListIterator itr = trial1.listIterator();
		while (itr.hasNext())
			System.out.print(itr.next());

	}

	public static void main(String[] args) {
		String input = "Geeks For Atul";

		reversesecond(input);
		reverseThird(input);
		reverseWordInMyString(input);

	}

}
