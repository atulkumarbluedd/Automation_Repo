package practiceProjectcoding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class allStringPermutations2 {
	public static void main(String[] args) {

		String str = "ABCDEF";
		Set<String> set = permutationOfString(str);
		System.out.println("Permutations of String " + str + " are:");
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			/********************************************************************************************************/
			/** smallest and largest number in an array */
			int arr[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };

			// assign first element of an array to largest and smallest
			int smallest = arr[0];
			int largest = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > largest)
					largest = arr[i];
				else if (arr[i] < smallest)
					smallest = arr[i];

			}
			System.out.println("Smallest Number is : " + smallest);
			System.out.println("Largest Number is : " + largest);
		}
	}

	/* Using Recursion */
	public static Set permutationOfString(String str) {
		Set permutationSet = new HashSet();

		if (str.length() == 0) {
			permutationSet.add("");
			return permutationSet;
		}

		// take out first character of String and send the remaining in the recursion
		char c = str.charAt(0);
		// Remaining String
		String rem = str.substring(1);
		
		System.out.println("*****" +rem);
		

		Set<String> permutatedSetForRemainingString = permutationOfString(rem);
		for (String permutedString : permutatedSetForRemainingString) {
			for (int j = 0; j <= permutedString.length(); j++) {
				String permutation = insertFirstCharAtDiffPlaces(permutedString, c, j);
				permutationSet.add(permutation);
			}
		}
		return permutationSet;
	}

	public static String insertFirstCharAtDiffPlaces(String perm, char firstChar, int index) {
		// Inserting firstCharacter of orig String at difference places based on index
		String String = perm.substring(0, index) + firstChar + perm.substring(index);// here we are doing substring from
																						// 0,2 and then add the first
																						// char and then add do
																						// substring to 2. 2 is length
																						// of the permutation.
		return String;
	}

}
