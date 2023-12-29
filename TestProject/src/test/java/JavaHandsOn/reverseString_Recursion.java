package JavaHandsOn;

import java.util.Arrays;

import org.testng.annotations.Test;

public class reverseString_Recursion {

	@Test
	public void reverseString() {
		char[] str = "geeksforgeeks".toCharArray();
		reverseString(str,0);
	    System.out.println(new String(str));
		/* check how many times a leeter appear in a string*/
		String str2= new String("12hellowhellowbrother");
		long res=str2.chars().filter(c->c=='1').count();

		System.out.println((int)res);

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
