package practiceProjectcoding;

public class reverseArray {
	// Reverse an array
	public static void main(String[] args) {

		int temp;
		// int nums[]= new int[4]
		int[] arr = { 6, 2, 3, 4 };
		int l = arr.length;

		int n = Math.floorDiv(l, 2); // Used to get [] greatest intiger funtion
//		int n=l%2;
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] + arr[l - i - 1];
			arr[l - i - 1] = arr[i] - arr[l - i - 1];
			arr[i] = arr[i] - arr[l - i - 1];
//			
//			arr[i] = arr[i] ^ arr[l - i - 1];
//			arr[l - i - 1] = arr[i] ^ arr[l - i - 1];
//			arr[i] = arr[i] ^arr[l - i - 1];

//			temp = arr[i];
//			arr[i] = arr[l - i - 1];
//			arr[l - i - 1] = temp;
		}

		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

}
