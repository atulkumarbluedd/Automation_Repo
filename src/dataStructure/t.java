package dataStructure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class t {
	void withOutSorting(int[] arr) {
		
		
		System.out.println("Without Sorting the array");
		String[] arr2 = new String[arr.length];

		for (int i = 0; i < arr2.length; i++)
			arr2[i] = null;
		int j = 0, found = 0;
		arr2[0] = "" + arr[0];

		for (int i = 0; i < arr.length; i++) {
			while (arr2[j] != null) {
				int temp = Integer.parseInt(arr2[j]);
				if (arr[i] == temp) {
					found = 0;
				}
				j++;
			}

			if (found == 1) {
				arr2[j] = "" + arr[i];
			}
			found = 1;
			j = 0;
		}
		System.out.println("Removed Dups without Sorting");
		j = 0;
		while (arr2[j] != null)
			System.out.print(arr2[j++] + " "); // print and then increament.

	}

	/***
	 * exchange the first and last word and swap rest of the characters
	 * 
	 * @return
	 */
	static String swapExchangeFirstAndLastAndReverseRestWords(String s) {
		// Taking an Empty String
		String fst = "";
		String totalString = "";
		int i = 0;
		for (i = 0; i < s.length();) {

			// Iterating from starting index
			// When we get space, loop terminates
			while (s.charAt(i) != ' ') {
				fst = fst + s.charAt(i);
				i++;
			}
			// After getting one Word
			break;
		}

		// Taking an Empty String
		String last = "";
		int j = 0;
		for (j = s.length() - 1; j >= i;) {

			// Iterating from last index
			// When we get space, loop terminates
			while (s.charAt(j) != ' ') {
				last = s.charAt(j-s.lastIndexOf(totalString)) + last;
				j--;
			}
			// After getting one Word
			break;
		}
		 
		totalString = totalString + last;
		// Printing last word
		for (int m = j; m >= i; m--) {

			// Reversing the left characters
			totalString = totalString + s.charAt(m);
			System.out.print(s.charAt(m));
		}

		// Printing the first word
		totalString = totalString + fst;
		System.out.println(fst);
		return totalString;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 1, 8, 1, 2, 3, 4, 5, 1, 8 };

//		List<int[]> lst = Arrays.asList(i);
//		// remove duplicates in the array
//
//		Set<List<int[]>> set = new HashSet<List<int[]>>();
//
////		Collection<List<int[]>> c=new HashSet<List<int[]>>();
//		lst.clear();
////		c.addAll(s);
//		Collections.addAll(set);
//		for (int[] a : lst) {
//			System.out.println(a);
//		}

		new t().withOutSorting(a);

		/* convert string into char Array and then again convert it into string */
		String st = "Hello World baby Welcomes You";
		char[] ch1 = st.toCharArray();
		new String(ch1);
		System.out.println(new String(ch1));

		/**** Replace word in place **/
		char[] ch = st.toCharArray();
		String reverse = "";
		for (int i = 0; i < ch.length; i++) {

			// k stores index of first character
			// and i is going to store index of last
			// character.
			int k = i;
			while (i < ch.length && ch[i] != ' ')
				i++;

			// here i stores the last index and K store first index
			// Swapping till last is greater than first index
			while (k < i) {
				char temp = ch[k];
				ch[k] = ch[i - 1];
				ch[i - 1] = temp;

				i--;
				k++;
			}
			reverse = new String(ch);

			// We assume that there is only one space
			// between two words.
		}

		System.out.println(reverse);
		String s1 = new t().swapExchangeFirstAndLastAndReverseRestWords("Hi how are you geeks ");

		System.out.println(s1);
	}

}
