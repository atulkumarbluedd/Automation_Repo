package practiceProjectcoding;

import java.util.Stack;

public class BuildLowestByremove {
	/* here we have to remove k numbers and then need to make the number lowest */
	// class variable is used because Java is
	// strictly pass by value so "wrapper won't work"
	// as res is passed by reference
	static String res = "";

	// A recursive function that removes
	// 'n' characters from 'str' to store
	// the smallest possible number in 'res'
	static void buildLowestNumberRec(String str, int n) {

		// If there are 0 characters to remove from str,
		// append everything to result
		if (n == 0) {
			res.concat(str);
			return;
		}

		int len = str.length();

		// If there are more characters to
		// remove than string length,
		// then append nothing to result
		if (len <= n)
			return;

		// Find the smallest character among
		// first (n+1) characters of str.
		int minIndex = 0;
		for (int i = 1; i <= n; i++)
			if (str.charAt(i) < str.charAt(minIndex))
				minIndex = i;

		// Append the smallest character to result
		res += str.charAt(minIndex);

		// substring starting from
		// minIndex+1 to str.length() - 1.
		String new_str = str.substring(minIndex + 1);

		// Recur for the above substring
		// and n equals to n-minIndex
		buildLowestNumberRec(new_str, n - minIndex);
	}

	public static String methhods(String str, int k) {
		Stack<Character> mystack = new Stack<Character>();
		int temp = k;
		char[] num = str.toCharArray();
		int n = num.length;

		for (char c : num) {
			while (!mystack.empty() && k > 0 && mystack.firstElement() > c) {
				mystack.pop();
				k -= 1;
			}
			if (!mystack.empty() || c != '0') {
				mystack.push(c);
			}
		}

		// now remove the largest value from the top of the stack
	 
		while(!mystack.empty() && k!=0)
		{
			mystack.pop();
			
		}
		if (mystack.empty()) {
			return "0";

		}
		while (!mystack.empty()) {
			num[n - 1] = mystack.firstElement();
			mystack.pop();
			n = n - 1;

		}
		return str.substring(n);
	}

	// Driver Code
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "1431620";
		// logic is need to remove the just last maxima
//		i.e most significant digit should be as low as possible other than Zero.
		// zero case can be considered or not depend on the interviwer

		int n = 4;
		buildLowestNumberRec(str, n);
		System.out.println(res);
		String temp = methhods(str, n);
		System.out.println(temp);

//		Class loadClass = Class.forName("sample");
	}

}
