package dataStructure;

public class piramid {

	public static void main(String[] args) {
		int rows = 10;

		for (int i = 1; i <= rows; ++i) {
			int k = 0;
			for (int space = 1; space <= rows - i; ++space) {
				System.out.print("  ");
			}

			while (k != 2 * i - 1) {
//	        System.out.print("* ");
				System.out.print(k + " ");
//	    	  System.out.print(i+" ");
				++k;
			}
			System.out.println();
		}
		/* left triangle */
		for (int i = 0; i < rows; i++) {
			// inner loop work for space
			for (int j = 2 * (rows - i); j > 0; j--) {
				System.out.print(" ");
			}
			// inner loop for columns
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}

		/* print piramid */
		for (int i = 0; i < rows; i++) {
			for (int j = rows - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("/****************pattern 3 Pyramid pattern*********/");
		for (int i = 0; i <= rows; i++) {

			for (int j = 0; j < rows - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("/****************pattern 3 Downward Triangle Star Pattern*********/");
		for (int i = 0; i < rows; i++) {
			for (int j = rows; j > i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("/****************pattern  Reverse Pyramid Star Pattern*********/");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < rows - i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		// approach 2
		for (int i = 0; i <= rows - 1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= rows - 1 - i; k++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}

		System.out.println("*************** Right Pascal's Triangle ***************");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = 0; i < rows; i++) {

			for (int j = rows - i; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("**************Left Pascal's Triangle OR diamond pattern******************");

		/*
		 * Diamond pattern -- use (* and Space) For Pascal's triangle use only star
		 */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < rows - i; j++) {

				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("********* Sandglass Star Pattern***************");

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < rows - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = 0; i < rows; i++) {
			for (int j = rows - i; j >= 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("*********Pattern # 8 Triangle Star Pattern**************");

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				if (j == 1 || j == (2 * i - 1) || i == rows) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("*********Pattern # 9 Down Triangle Pattern**************");

		for (int i = rows; i >= 1; i--)
		/* Just need to change the outer for loop */
		{

			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				if (j == 1 || j == (2 * i - 1) || i == rows) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("************pattern 10 Hollow Diamond Star Pattern*******************");

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				if (j == 1 || j == (2 * i - 1)) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}

		for (int i = rows; i >= 1; i--) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i - 1); j++) {
				if (j == 1 || j == (2 * i - 1)) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("********** pattern 11 glass number pattern***************");

		int n = 8;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= n; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= n; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		
		
		System.out.println(" ******************  pattern 12 ");
		
		
		
		
//		361614537

	}

}
