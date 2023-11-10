package DataStructure;

import java.util.HashMap;

public class longestincrerasingsubsequence {

	public static void main(String[] args) {

		/*
		 * AlGO* Here first we create a map and then we put true for all the value as
		 * true then we have to check just previous number and if the number is exist
		 * then we mark it as false And then finally we have to work with the true
		 * values and then we will increase with one by one for the current value And
		 * then check whether value exist in the map or not by increasing value by one
		 * At last we swap the value with the maxStart and maxLast with the greatest length
		 * finally we will print the sequence
		 */

		int arr[] = { 10, 5, 9, 1, 11, 8, 6, 15, 5, 12, 2, 15, 16, 17, 18, 19, 21, 20 };

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for (int value : arr) {
			map.put(value, true); // here we will put true for every number 
		}

		for (int value : arr) {
			if (map.containsKey(value - 1)) {
				map.put(value, false); // here we put false because we know that the lower value exist means this value
										// can't be the starting point
			}
		}

		int msp = 0, ml = 0; // max starting point and maximum length;

		for (int value : arr) { // this loop will give us the maximum starting point and length
			if (map.get(value) == true) {
				int tl = 1, tsp = value;
				while (map.containsKey(tsp + tl)) {
					tl++;
				}
				if (tl > ml) { // here we will compare the previous as well as current length and will take the
								// largest one
					msp = tsp;
					ml = tl;

//					/**/ Below Code is for prinitng all the sub sequences  ");
//					for (int i = 0; i < ml; i++) {
//
//						System.out.print(msp+" ");
//						msp++;
//					}

				}
			}

		}

		for (int i = 0; i < ml; i++) {

			System.out.print(msp+" ");
			msp++;
		}
	}
}
