package practiceProjectcoding;

import java.util.Collections;
import java.util.Arrays;
import java.util.Collections;

public class PalindromeCreation {
	public static int isPalindorme(char[] chararray, int begin, int end) {

		if (begin >= end) {
			return 1;// it will check only 1 char pr zero then it will return 1 i.e palindrome
		}
		if (chararray[begin] == chararray[end])

		{
			return isPalindorme(chararray, begin + 1, end - 1);
		}

		else {
			return 0;
		}

	}

	public static int revesreNumber(int n) {
		int sum = 0;
		while (n != 0) {
			int r = n % 10;
			sum = sum * 10 + r;
			n = n / 10;
		}
		return sum;
	}

	public int palindromeNumber(int n) {
		int sum = 0;
		int temp = n;
		while (n != 0) {
			int r = n % 10;
			sum = sum + r * 10;
			n = n / 10;
		}

		if (temp == sum) {
			return 1;
		}
		return sum;
	}

	public static int[] numberToArray(int number) {
		String numberString = Integer.toString(number);
		int length = numberString.length();
		int[] arr = new int[length];
		for (int j = 0; j < length; j++) {
			arr[length - 1 - j] = number % 10;
			number = number / 10;

		}

		return arr;
	}

	public static int fibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fib = fibonacci(number - 1) + fibonacci(number - 2);
		return fib;
	}

	public static void main(String[] args) {
//		int a[] = new int[] { 1, 4, 4, 1 };
////		String str = "agah";
////		char[] a = str.toCharArray();
//		if (PalindromeCreation.isPalindorme(a, 0, a.length - 1) == 1) {
//			System.out.println(" palinddrome");
//		} else {
//			System.out.println(" not ");
//		}
//
		/************ number palindrome creation ********************************/
		PalindromeCreation pc = new PalindromeCreation();
		int number = 4553;
		int[] numArray = PalindromeCreation.numberToArray(number);

		number = number + PalindromeCreation.revesreNumber(number);
		System.out.println(number + "" + PalindromeCreation.revesreNumber(number));
		String temp = (number + "" + PalindromeCreation.revesreNumber(number)).toString();
		try {
			number = Integer.parseInt(temp);
		} catch (Exception e) {

		}

		/************* String palindrome creation and checking ********************/
		String str = "hello";
		char[] chararray = str.toCharArray();
		int length = chararray.length;
//		char reverse[]= new char[chararray.length];
		String tempstring = "";
		if (PalindromeCreation.isPalindorme(chararray, 0, chararray.length - 1) != 1) {
			for (int i = 0; i < chararray.length; i++) {
				 
				str = str + str.charAt(length - i - 1);
			}
		}

		System.out.println(str.toCharArray());
		System.out.println(PalindromeCreation.isPalindorme(str.toCharArray(), 0, str.toCharArray().length - 1)); // is

		System.out.println(PalindromeCreation.fibonacci(5));// string
															// palindrome
		PalindromeCreation.fibonacci(12);

//		System.out.println(number);
//
//		int i = PalindromeCreation.revesreNumber(4553);
//		System.out.println(i);

	}

}
