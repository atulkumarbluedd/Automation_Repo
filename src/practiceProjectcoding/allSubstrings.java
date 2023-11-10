package practiceProjectcoding;

import java.util.HashSet;
import java.util.Set;

public class allSubstrings {
	public static void main(String args[]) {
		String str = "abbc";
		System.out.println("All substring of abbc are:");
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));

			}
		}
		
		String S= "testing is easy";
		String S1= "testing is easy";
		char[] t = S.toCharArray();
		Set<String> set= new HashSet<String>();
		 System.out.println(set.add(S));
		 System.out.println(set.add(S1));
		 for(String s: set)
		 {
			 System.out.println(s);
		 }
	}
}
