package done;

public class palindromeInplace {
	boolean flag = false;

	boolean palindromecheck(String str1, int start, int end) {
		if (start >= end) {
			return true;// it will check only 1 char or zero then it will return 1 i.e palindrome
		}

		if ((str1.charAt(start)) == (str1.charAt(end))) {
			System.out.println(str1.charAt(start)+" :: "+str1.charAt(end));
			return palindromecheck(str1, start + 1, end - 1);
			

		} else {
			return false;
		}
		
	}

	public static int isPalindorme(char[] chararray, int begin, int end) {

		if (begin >= end) {
			return 1;// it will check only 1 char pr zero then it will return 1 i.e palindrome
		}

		if (chararray[begin] == chararray[end]) {
			return isPalindorme(chararray, begin + 1, end - 1);
		}

		else {
			return 0;
		}

	}

	public static boolean isPalindrome(int number) {
		int temp=number, sum = 0;
		while (number != 0) {
			int t=number %10;
			sum= sum*10 +t;
			
			number=number/10;
		 

		}
		if(temp==sum)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}

	public static void main(String[] args) {

		/* create a palindrome and check if not palindrome */
		System.out.println(" ********** Palindrome for a number ******");

		String str = "TOOT";
		char[] chararray = str.toCharArray();
		palindromeInplace p = new palindromeInplace();
		boolean value = p.palindromecheck(str, 0, str.length() - 1);

		System.out.println(value);
		int value1 = p.isPalindorme(chararray, 0, chararray.length - 1);

		System.out.println(value1);
		
		System.out.println(p.isPalindrome(1234));
		System.out.println(p.isPalindrome(123321));
	}

}
