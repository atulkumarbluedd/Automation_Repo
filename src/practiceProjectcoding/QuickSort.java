package practiceProjectcoding;

import java.util.Arrays;

public class QuickSort {

	public void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high); // calling partition

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public static int partition(int arr[], int low, int high) {

		/*
		 * This function takes last element as pivot, places the pivot element at its
		 * correct position in sorted array, and places all smaller (smaller than pivot)
		 * to left of pivot and all greater elements to right of pivot
		 */

		int pivot = arr[high], pindex = low; // decided the pivot and the start index
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {

  // swap with partion index elemnt with the

				int temp=arr[i];
				arr[i]=arr[pindex];
				arr[pindex]=temp;
				pindex++;
			}
		}
		
//		QuickSort.swap(arr[pindex], arr[high]);
		int temp=arr[pindex];
		arr[pindex]=arr[high];
		arr[high]=temp;
		
		return pindex;
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 4, 55, 6, 7, 8 };

		int l = arr.length - 1;
		System.out.println(" length" + l);
		QuickSort ab = new QuickSort();
		ab.sort(arr, 0, 5);
		for (int a : arr) {
			System.out.print("  " + a);
		}

	}

}
