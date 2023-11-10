package done;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatedChars {
	/*
	 * Algo:: keep two pointers i and j. i at the beginning j will run just less then
	 * the length now if the characters start repeating then we need to remove from
	 * the beginning and then we will get the desired string
	 */
	public static void main(String[] args) {

		String str = "abcabcbb";

		int i = 0, j = 0, max = 0;
		// i is at the begining 
		// j is going to expand the window
		
		HashSet<Character> hash_set = new HashSet<>();
		while (j < str.length()) {
			if (!hash_set.contains(str.charAt(j))) {
				hash_set.add(str.charAt(j));
				j++; // need to expanding the window
				max= Math.max(hash_set.size(), max);
			}else
				{
					hash_set.remove(str.charAt(i));
					i++;
				}

			}
		System.out.println(max);
		System.out.println(hash_set);
		 
		}

	}
 
