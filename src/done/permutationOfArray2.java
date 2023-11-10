package done;

public class permutationOfArray2 {

	public static void printArray(int arr[]) {
		System.out.println("");
		for (int a : arr) {

			System.out.print(a + " ");
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printPermutation(int[] arr, int cid) {
		
		if (cid == arr.length - 1) {// if this is the last element of the array
			printArray(arr); // when we are at the last element then we want to print the array
//			return;  
		}

		for (int i = cid; i < arr.length - 1; i++) {
			
			if(arr[i]!=arr[cid] || i== cid) // this condition will check if the element is same then no need to do the swapping 
				// it will take care of the duplicates.
			{
				swap(arr, i, cid);
				printPermutation(arr, cid + 1);
				swap(arr, i, cid);
			}
			
		}

	}

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 2, 3, 4};
		printPermutation(arr, 0);

	}

}
