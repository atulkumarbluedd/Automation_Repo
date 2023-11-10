package practiceProjectcoding;

public class ArrayConsecutiveElementMain {

	private int getMinimum(int arr[], int n) {
		int min = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	/* Method return maximum value */
	private int getMaximum(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	/* This method checks if array elements are consecutive */
	public boolean checkArrayContainsConsecutiveElement(int arr[], int length) {
		if (length < 1)
			return false;

		int min = getMinimum(arr, length);
		int max = getMaximum(arr, length);

		if (max - min + 1 == length) {
			boolean[] visited = new boolean[arr.length];
			for (int i = 0; i < length; i++) {
				if (visited[arr[i] - min] != false) // if this condition came true means it has duplicate element
					return false;

				visited[arr[i] - min] = true;
			}

			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		ArrayConsecutiveElementMain acem = new ArrayConsecutiveElementMain();
		int arr[] = { 47, 43, 45, 44, 46 };

		if (acem.checkArrayContainsConsecutiveElement(arr, arr.length))
			System.out.println(" Array elements are consecutive ");
		else
			System.out.println(" Array elements are not consecutive ");
		return;
	}

}
