package practiceProjectcoding;

import java.util.Arrays;

public class reverseArrayAndString {

	String reverseString(String str, int start, int end) {
		String rversedString = "";
		char[] str1 = str.toCharArray();
		/** reverse an string **/

		while (start < end) {
			// XOR for swapping the variable

			str1[start] ^= str1[end];
			str1[end] ^= str1[start];
			str1[start] ^= str1[end];

			++start;
			--end;
		}

		for (char c : str1) {
			rversedString = rversedString + c;

		}

		return rversedString;

	}

	public void reverseWordInMyString(String str) {
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

	public static void main(String[] args) {
		/* reverse Array */
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int n = arr.length;

		for (int i = 0; i < n / 2; i++) {
			arr[i] = arr[i] + arr[n - i - 1];
			arr[n - i - 1] = arr[i] - arr[n - i - 1];
			arr[i] = arr[i] - arr[n - i - 1];
		}
		System.out.println(Arrays.toString(arr));

		/** reverse word in string **/

		String sentence = "hello brother are you mad";
		String reversed = "";
		for (int i = sentence.length() - 1; i >= 0; i--) {
			int k = i; // last characters index stored in the index i;
			while (i >= 0 && sentence.charAt(i) != ' ') {
				i--;
			}
			int j = i + 1; // store the index of the first letter of word

			while (j <= k) {
				reversed = reversed + sentence.charAt(j);
				j++;
			}
			reversed = reversed + " "; // to enter the space in between the words

		}

		System.out.println(reversed+"---------");

		/* Rverse word in place also */
		String sentence1 = "hello brother are you mad";
		String str1 = "";
		System.out.println(new reverseArrayAndString().reverseString(sentence1, 0, sentence1.length() - 1));

		/* Reverse words in a string method--------->1 */
		new reverseArrayAndString().reverseWordInMyString("Welcome to BeginnersBook");
		/* Reverse words in a string method--------->2 */
		String n1[] = "Welcome to BeginnersBook".split(" ");
		String reverse = "";
		for (String v : n1) {
			reverse = reverse + new reverseArrayAndString().reverseString(v, 0, v.length() - 1) + " ";
		}
		 
		/***NEED to work on below logic*/
//		for(int i=0; i<sentence1.length();i++)
//		{
//			int Strt=i, end;
//			while(sentence1.charAt(i)!=' '&& i<sentence1.length())
//			{
//				System.out.println(i);
//				i++;
//			}
//			if(sentence1.charAt(i)==' ' && i<sentence1.length());
//			{
//				reverse = reverse + new reverseArrayAndString().reverseString(sentence1, Strt,i-1) + " ";
//			}			
//		}
//		System.out.println(reverse+" 0000");

	}

}