package JavaHandsOn;

import java.util.Arrays;

import org.testng.annotations.Test;

public class reverseString_Recursion {

	@Test
	public void reverseString() {
		char[] str = "geeksforgeeks".toCharArray();
		reverseString(str,0);
	    System.out.println(new String(str));
	}

	static void reverseString(char[] chArr, int i) {
		int n = chArr.length;
		if (i == n / 2)
			return;
		/**
		 * swap
		 */
		char temp = chArr[i];
		chArr[i] = chArr[n - i - 1];
		chArr[n - i - 1] = temp;
		reverseString(chArr, i + 1);
	}
}
