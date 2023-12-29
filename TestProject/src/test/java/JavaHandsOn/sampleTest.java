package JavaHandsOn;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class sampleTest {
	public static void main(String[] args) {
		/*
		 * PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		 * 
		 * int score[] = new int[] { 1, 3, 4, 9 }; PriorityQueue<Integer> pq = new
		 * PriorityQueue<>((a, b) -> a - b);
		 * 
		 * for (int i = 0; i < score.length; i++) { pq.add(score[i]); } pq.remove(19);
		 * Iterator<Integer> val = pq.iterator(); while (val.hasNext()) {
		 * System.out.println(val.next()); } System.out.println(pq); Stack<Integer>
		 * stack = new Stack(); stack.push(2); stack.push(4);
		 * System.out.println(stack.pop());
		 */

	     
           
           Stack<String> forward= new Stack<>();
           forward.push("hjh");
           forward.push("32");
           forward = new Stack();
           System.out.println(forward+" : ");
           
           
 

		/***
		 * find the floor value of square root of a number
		 */
		System.out.println(Math.floor(Math.sqrt(10)));
		int val = Integer.compare(4, 9);
//		/**
//		 * compare two numbers if left side number is small it gives -1 else 1 and if
//		 * numbers are equal then gives 0
//		 */
//		System.out.println(val);
//		String v = Integer.toString(3);
//
//		ArrayList<Integer> list = new ArrayList();
//		
//		list.add(2);
//		list.add(4);
//		Collections.reverse(list);
//		list.remove(0);
//		System.out.println(list);
//		String s="57";
//		int k1=Integer.valueOf(s);
//		k1++;
//		System.out.println(k1);
//		int j=34;
//		String ss=String.valueOf(j);

	}

	@Test
	public String sampletest(String input){
		char[] charr=input.toCharArray();
		int left=0;
		int right=input.length()-1;
		while(left<=right){
			if(charr[left]!=' ')
			{
				char temp=charr[right];
				charr[right]=charr[left];
				charr[left]=temp;
				left++;
				right--;
			}
			else if(input.charAt(left)==' ') left++;
			else if(input.charAt(right)==' ') right--;
		}
		return new String(charr);
	}

	@Test(description = "reverse string ignore space")
	public void sampleSa(){
		String s=sampletest(" Hi There");
		System.out.println(s);
		System.out.println(
				s.equals(" er ehTiH")
		);
	}


}
