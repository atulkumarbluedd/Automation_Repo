package practiceProjectcoding;

public class selectionSort {
	/*** here intention is to find the min element and then replace this element */
	public void selectionsort(int arr[], int n) {
		for (int i = 0; i < n - 1; i++) {
			int imin = i;// store the indexes of the min element to be compared
			for (int j = i + 1; j < n; j++) {

				if (arr[i] > arr[j]) {
					imin = j; // update the index of the min element
				}
			}
			int temp = arr[imin];
			arr[imin] = arr[i];
			arr[i] = temp;
		}

	}

	// O(n2)
	public static void main(String[] args) {

		selectionSort sa = new selectionSort();
		int[] arr = { 1, 2, 4, 8, 3, 0 };
		sa.selectionsort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
