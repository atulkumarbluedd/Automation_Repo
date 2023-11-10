package practiceProjectcoding;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class rmoveduplicateArrayList extends Clipboard {

	public rmoveduplicateArrayList(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int binarySearch(int arr[], int low, int high, int key) {
		int mid = (low + high) / 2;

		while (low <= high) {
			if (arr[mid] < key) {
				low = mid + 1;

			} else if (arr[mid] == key) {
				return mid;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;

		}
		if (low > high) {
			return -1;

		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList EmpnameList = new ArrayList();
		EmpnameList.add("ram");
		EmpnameList.add("shyam");
		EmpnameList.add("ram");
		EmpnameList.add("ram");
		EmpnameList.add("shyam");
		EmpnameList.add("ram");
		System.out.println(" before removing ");
		for (Object s : EmpnameList) {
			System.out.print(s + " ");
		}
		System.out.println();
		EmpnameList = new ArrayList(new LinkedHashSet(EmpnameList));
		System.out.println(" After removing ");
		for (Object vc : EmpnameList) {
			System.out.print(vc + " ");
		}

		System.out.println();
		System.out.println("/*** second program leetcode 977**/");

//		int[] A=new int[] {2,3,1,5};
//		int [] num= new int[]{A.length};
//		 int l=A.length-1;
//		 int begin=0;
//		 int end=A.length-1;
//		 while(l>=0)
//		 {
//			 if((A[begin]*A[begin])>(A[end]*A[end]))
//			 {
//				 num[l--]=A[begin]*A[begin];
//				 begin++;
//			 }
//			 else
//			 {
//				 num[l--]=A[end]*A[end];
//				 end--;
//			 }
//		 }
//		 System.out.println(Arrays.toString(A)); 
		String str = "hello i am a boy";
		String str2 = "";
		LinkedList<Integer> ll = new LinkedList<>();

		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println(ll);

		LinkedList<Integer> ll1 = new LinkedList<>();

		ll.descendingIterator().forEachRemaining(ll1::add);

		System.out.println(ll1);

		/** remove **/

		Integer[] input = { 5, 1, 2, 3, 2, 1, 4, -1 };
		Integer[] a2 = { 1, 2, 3 };
		Integer[] a3 = { 1, 2, 3, 4 };

		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int value : input) {
			if (value > highest) {
				secondHighest = highest;
				highest = value;

			} else if (value > secondHighest) {
				secondHighest = value;
			}

		}
		System.out.println(Arrays.toString(input) + "-----" + secondHighest + "::" + highest);

		Set s = new HashSet<>(Arrays.asList(input));
		Set s2 = new HashSet<>(Arrays.asList(a3));
		if (s.size() != s2.size())
			System.out.println(false);
		else {
			for (Object value : s) {
				if (!s2.contains(value))
					System.out.println(false + ":" + value);

			}
		}

		/***** Programme ****/

//		Random rand = new Random();
//		for(int i=0; i<90; i++)
//		System.out.print(rand.nextInt(9)+" ");

//		rand.nextInt(array.length);
		String pattern = "MM/dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date(0));
		System.out.println(date); // 06-23-2020

		System.out.println("/***************sort the map values*********/");

		Map<String, Integer> scores = new HashMap<>();
		scores.put("David", 95);
		scores.put("Jane", 80);
		scores.put("Mary", 97);
		scores.put("Lisa", 78);
		scores.put("Dino", 65);

		System.out.println(scores);

		Map<String, Integer> sortedByValue = new LinkedHashMap<>();

		// get the entry set
		Set<Entry<String, Integer>> entrySet = scores.entrySet();
		System.out.println(entrySet + ":");

		// create a list since the set is unordered
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		System.out.println(entryList);

		// sort the list by value
		entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
		System.out.println(entryList);

		// populate the new hash map
		for (Entry<String, Integer> e : entryList)
			sortedByValue.put(e.getKey(), e.getValue());

		System.out
				.println("*******************frequency of every character********************************************");

		String inputstring = "abcdABCDabcd";
		char[] array = inputstring.toCharArray();
		Map<Character, Integer> charmap = new HashMap<Character, Integer>();
		for (char c : array)
			if (!charmap.containsKey(c))
				charmap.put(c, 1);
			else
				charmap.put(c, charmap.get(c) + 1);

		System.out.println(charmap);
		System.out.println();
		System.out.println("/******remove white spaces from the string text*****/");

		// copying File path to Clipboard
		StringSelection str1 = new StringSelection("C:\\Users\\Chait\\Desktop\\File upload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);

		String tempstring = "Saket Saurav        is an Autom ation Engi ne      er";

		StringBuffer strb = new StringBuffer();

		for (int i = 0; i < tempstring.length(); i++) {
			if (tempstring.charAt(i) != ' ' && tempstring.charAt(i) != '\t') {
				strb.append(tempstring.charAt(i));
			}
		}
		System.out.println(strb);

		Integer[] num = { 7, 34, 45, 23, 38, 56, 21 };
		/*
		 * First we convert an Array to List using Arrays.asList(), then pass the list
		 * as an argument to the constructor of TreeSet
		 */
		List<Integer> list = Arrays.asList(num);
		Set<Integer> set = new TreeSet<Integer>(list);
		Queue<Integer> l = new ArrayDeque<Integer>(list);

		set.add(90);
		Integer[] temp = set.toArray(num);

		System.out.println(Arrays.toString(temp) + " array is here ");
		for (Integer var : l)
			System.out.print(var + " ");

		// Show Set elements
		System.out.println("The Set elements are :");
		for (Integer var : set)
			System.out.print(var + " ");

		System.out.println("******************************");

		for (Integer integer : list) {
			System.out.print(integer + " ");

		}
		System.out.println("The Set elements are  :");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("The Set elements are  :");
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("******************************");

		ArrayList readableList = new ArrayList();
		readableList.add("Jeffrey Archer");
		readableList.add("Khalid Hussain");

		List unmodifiableList = Collections.unmodifiableList(readableList);

		readableList.set(0, "J.K. rowling");
		readableList.set(1, "teststtststst");

		readableList.add("hello brother");
		for (Object ss : readableList) {
			System.out.println(ss);
		}

		System.out.println();
		System.out.println("**************Anagram****************");

		// 1st check length
		// 2nd sort and then compare

		System.out.println("*************swap first and last character of string ******");

		String input1 = "geeks for geeks";
		char ch[] = input1.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			/* k stores 1st char index and i stores the last index */
			int k = i;
			while (i < ch.length && ch[i] != ' ')
				i++;
			// swapping
			char temp1 = ch[k];
			ch[k] = ch[i - 1];
			ch[i - 1] = temp1;
		}
		System.out.println(new String(ch));

		System.out.println("*************swap corner words and swap middle words in string******");

		ExchangeFirstLastReverseMiddle("Hello World GFG Welcomes You");
		System.out.println();

		int[] tempArray = new int[] { 5, 6, 7, 8, 1, 2, 3, 4, 2 };
//		checkconsecutiveElement()

		System.out.println(
				" ***************************whether array contains consecutive sequence ?***********************************88");

		int max = getMax(tempArray);
		int min = getMin(tempArray);
		System.out.println(max + " :: " + min);
		int length = tempArray.length;
		boolean flag = false;

		if (length < 1)
			flag = false;
		if (max - min + 1 == length) {

			boolean[] visited = new boolean[length];

			for (int i = 0; i < length; i++) {
				if (visited[max - tempArray[i]] != false)
					flag = false;
				else
					visited[tempArray[i] - min] = true;

			}
			flag = true;
		} else
			flag = false; // if max-min+1!=n
		if (flag)
			System.out.println("elements are consecutive");
		else
			System.out.println("not consecutive array");

		System.out.println();

		System.out.println("*************************seperate even and odd in Array***************");

		int arr[] = { 12, 34, 45, 9, 8, 90, 3 };

		int high = arr.length - 1;
		int low = 0;
		while (low < high) {
			while (arr[low] % 2 == 0) {
				low++;

			}

			while (arr[high] % 2 != 0) {
				high--;
			}

			if (high > low) {
				int temp1 = arr[high];
				arr[high] = arr[low];
				arr[low] = temp1;
				low++;
				high--;

			}
		}
//		}
		for (int a : arr) {
			System.out.print(a + "  ");
		}

		System.out.println();
		System.out.println("***************even at even index and odd at odd index*******************");

		int arr2[] = { 3, 6, 12, 1, 5, 8 };
		seggregateEvenAtevenAndOddAtodd(arr2); // O(n)
		System.out.println("****************************************************************************");

		String str11 = "656%atula$";
		String s55 = str11.replaceAll("[^a-zA-Z0-9%]", "");
		System.out.println(" -------------------------- " + s55);
		
		int arr5[] = { -3, 6, 12, -1, 5, 8 };
		
		SeggregatePositiveAndnegative(arr5);
		System.out.println();
		
		System.out.println("************lexicographically sequency*******************");
		
		
		String tempstring1="dabcabc";
		String mx="";
		 
		for(int i=0; i<tempstring1.length();i++)
		 
		{
			int value=mx.compareTo(tempstring1.substring(i));
			if(value>0)
			{
				mx=tempstring1.substring(i);
			}
			 
				
		}
		
			
			System.out.println(mx);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/*
	 * Input : Hello World GFG Welcomes You Output :You semocleW GFG dlroW Hello
	 */
	public static void ExchangeFirstLastReverseMiddle(String s) {
		// Taking an Empty String

	}

	public static int getMin(int[] temp) {
		int min = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (min > temp[i])
				min = temp[i];
		}
		return min;
	}

	public static int getMax(int[] temp) {
		int max = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (max < temp[i])
				max = temp[i];
		}
		return max;
	}

	public static void seggregateEvenAtevenAndOddAtodd(int arr[]) {
		int oddindx = 1, evenIndx = 0;
		while (true) {
			while (evenIndx < arr.length && arr[evenIndx] % 2 == 0)
				evenIndx += 2;
			while (oddindx < arr.length && arr[oddindx] % 2 != 0)
				oddindx += 2;

			if (evenIndx < arr.length && oddindx < arr.length)

			{
				int temp1 = arr[evenIndx];
				arr[evenIndx] = arr[oddindx];
				arr[oddindx] = temp1;
			}

			else
				break;

		}

		System.out.println();
		for (int h : arr)
			System.out.print(h + " ");

	}

	public static void SeggregatePositiveAndnegative(int arr[]) {

		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			
			while(arr[low]<0)
				low++;
				
			while(arr[high]>0)
				high--;
			
			if (low < high) {
				int temp1 = arr[high];
				arr[high] = arr[low];
				arr[low] = temp1;
				low++;
				high--;

			}
				
		}

		System.out.println();
		for (int h : arr)
			System.out.print(h + " ");

	}

}