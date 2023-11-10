package practiceProjectcoding;

public class combinationSum {

	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 8, 10 };
		
		for (int i = 0; i < arr.length; i++) {
		
			for (int j = 0; j < arr.length; j++)
			
				if (arr[i] + arr[j] == 10) {
					System.out.println(arr[i] + " : " + arr[j]);
				}
		}

		System.out.println("/** using while loop **/");
		/** using while loop **/
		int count=0;
		for (int i = 0; i < arr.length; i++) {

			int j = 0;
			while (j != arr.length - 1) {

				if (arr[i] + arr[j] == 10) {
					System.out.println(arr[i] + " : " + arr[j]);
					count++;
				}

				j++;
			}
		}
	System.out.println(count);
	}
}
