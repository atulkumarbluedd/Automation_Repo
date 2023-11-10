package practiceProjectcoding;

import java.util.HashMap;
import java.util.Map.Entry;

public class oddOcurrenceOfNumber {

	int getOddTimesElement(int ar[]) {
		int i;
		int result = 0;
		for (i = 0; i < ar.length; i++) {
			// XOR operation
			result = result ^ ar[i];
		}
		return result;
	}

	int getOddOcurrence2(int arr[]) {
		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int element = arr[i];
			if (elements.get(element) == null) {
				elements.put(element, 1);

			} else
				elements.put(element, elements.get(element) + 1);
		}
		for (Entry<Integer, Integer> entry : elements.entrySet()) {

			System.out.println(entry.getKey() + " :: " + entry.getValue());
			if (entry.getValue() % 2 == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		oddOcurrenceOfNumber occur = new oddOcurrenceOfNumber();
		int array[] = new int[] { 20, 40, 50, 40, 50, 20, 30, 30, 30, 50, 20, 40, 40, 20 };
//		System.out.println("Number which occurs odd number of times is : "+occur.getOddTimesElement(array));
		System.out.println(occur.getOddOcurrence2(array));
	}

}
