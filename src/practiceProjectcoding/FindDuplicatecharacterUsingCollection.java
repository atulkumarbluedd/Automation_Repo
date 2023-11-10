package practiceProjectcoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicatecharacterUsingCollection {
	public static void main(String args[]) {
		Map<Character, Integer> duplicate = printDuplicateCharacters("Programming");
		for (Entry<Character, Integer> entry : duplicate.entrySet()) {
			System.out.println(entry.getValue() +" :: "+ entry.getKey());
		}
		printDuplicateCharacters("Combination");
		printDuplicateCharacters("Java");
		String str="hllo234";
		str=str.replaceAll("[a-z]", "");
    System.out.println(str);
	}

	public static Map<Character, Integer> printDuplicateCharacters(String word) {
		char[] characters = word.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : characters) { // array traversing 
			if (charMap.containsKey(ch)) { // Map traversing and checking
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		return charMap;

	}
}