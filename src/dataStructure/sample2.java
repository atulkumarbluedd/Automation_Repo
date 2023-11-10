package dataStructure;

public class sample2 {

	/*
	 * Input - "COVID19 is a deadly disease" Output - "disease deadly a is COVID19"
	 * For eg: If the original string is "I want to go out" and the user inputs
	 * string to remove "ant" then it should print "I w o go ou" as output
	 */

	public static void main(String[] args) {

//		String str= "COVID19 is a deadly disease";
//		String[] words = str.split(" ");
//		String tempstring="";
//		for(int i=words.length-1;i>=0;i--)
//		{
//			 
//			tempstring=tempstring+words[i]+" ";
//		}
//		
//		System.out.println(tempstring);

		String str = "I want to go out";
		String str2 = "I want to go out";
		String temp = "ant";
//		 "I w o go ou"
		String dummyString = "";
		str = str.replaceAll("a", "");
		str = str.replaceAll("n", "");
		str = str.replaceAll("t", "");
		String str3 = str2.replace("[ant]", "");

		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < temp.length();j++) {

				if ((str.charAt(i) == temp.charAt(j)) && i < str.length()) {
					i++;
					break;
				}
				
			}
			dummyString = dummyString + str.charAt(i);
		}

		System.out.println(dummyString+"----");
	}
}
