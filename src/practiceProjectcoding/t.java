package practiceProjectcoding;

import java.util.Arrays;

public class t {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < arr.length - 1; i++) {
//
			for (int j = i + 1; j < arr.length - 1; j++) {
				if (arr[i] > arr[j]) {
//					int temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
					
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
//				}
////				if(arr[i]==arr[j])
////				{
////					System.out.println(arr[i]);
////				}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
