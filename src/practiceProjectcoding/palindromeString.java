package practiceProjectcoding;

import java.util.Scanner;

public class palindromeString {

	static boolean isPalindromeNumber(int n) {
		// Find the appropriate divisor
		// to extract the leading digit
		int divisor = 1;
		while (n / divisor >= 10)
			divisor *= 10;

		while (n != 0) {
			int leading = n / divisor;
			int trailing = n % 10;

			// If first and last digit
			// not same return false
			if (leading != trailing)
				return false;

			// Removing the leading and trailing
			// digit from number
			n = (n % divisor) / 10;

			// Reducing divisor by a factor
			// of 2 as 2 digits are dropped
			divisor = divisor / 100;
		}
		return true;
	}

	public static void main(String[] args) {

		String original, reverse = ""; // Objects of String class
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string/number to check if it is a palindrome");
		original = in.nextLine();
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		if (original.equals(reverse))
			System.out.println("Entered string/number is a palindrome.");
		else
			System.out.println("Entered string/number isn't a palindrome.");

		int number = 1001;
		System.out.println(isPalindromeNumber(number));
	}
}
