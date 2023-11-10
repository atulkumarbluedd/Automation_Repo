package practiceProjectcoding;

import java.util.Arrays;

public class convertStringIntoCharArray {
	String ConvertStringIntoCharArray(String str) {
		char[] chArray = new char[str.length()];
		int len = str.length() - 1;

		for (int i = str.length() - 1; i >= 0; i--) {
			chArray[i] = str.charAt(i);
		}
		return new String(chArray);
	}

	public static void main(String[] args) {
		String str = "Java4s";
		char[] chArray = new char[str.length()];
		convertStringIntoCharArray ch1 = new convertStringIntoCharArray();
//		for (int i = 0; i < str.length(); i++) {
//			chArray[i] = str.charAt(i);
//		}
//
//		for (char ch : chArray) {
//			System.out.print(ch + " ");
//		}
		String reversedString=ch1.ConvertStringIntoCharArray(str);
		System.out.println("reversedString : "+reversedString);
		char[] ch = ch1.ConvertStringIntoCharArray(str).toCharArray();

		
		System.out.println(ch1.ConvertStringIntoCharArray(str)+"------>");
//		for (char cc : ch) {
//			System.out.print(cc + " ");
//		}

		for (int i = 0; i < (ch.length) / 2; i++) {
			char temp = ch[i];
			ch[i] = ch[ch.length - 1 - i];
			ch[ch.length - 1 - i] = temp;
		}

		for (char cc : ch) {
			System.out.print(cc + " ");
		}

	}
}
