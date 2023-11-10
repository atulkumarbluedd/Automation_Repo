package practiceProjectcoding;

public class insertionSort {
	public static void main(String[] args) {
		int[] a = { 10, 9, 7, 101, 23, 44, 12, 78, 34, 23 };
		for (int i = 1; i < 10; i++) {
			int currrent = a[i]; // picked element
			int j = i - 1; // just before the previous item while loop variable
			while (j >= 0 && a[j] >= currrent) {
				a[j + 1] = a[j]; // we copy the element to right side if the element is greater than the current
				j--; // here j stores the
			}

			a[j + 1] = currrent; // picked element is put in the correct place

		}
		System.out.println("printing sorted elements ...");
		for (int i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
	}

}

/*
 * INSERTION SORT in insertion sort we need to create sorted and unsorted
 * partitions, and slowly we need to increase the sorted part for that we have to
 * run the outer loop and every time we have to store the element in the current
 * variable.
 * logic : First pick one element and then compare it with other elements and then Place the element at the correct place.
 */
