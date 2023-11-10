package done;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReverseString {

	 
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
		 

	}

}
