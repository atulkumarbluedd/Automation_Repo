package done;

import java.util.Arrays;

public class SwapArray {

	void reverse(int[] arr) {
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
		}

	}

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 14, 5, 6 , 6,5};
		SwapArray t = new SwapArray();
		t.reverse(arr1);
		System.out.println(Arrays.toString(arr1));

		int  count = 0, visited=-1;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if ((arr1[i] == arr1[j])&& visited!=-1) {
					
					visited=count+1;
					System.out.println(arr1[i]   + " ----");
					count++;
				}
			}
			
		}
 
	}
}
