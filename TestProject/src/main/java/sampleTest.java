import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleTest {
	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 4 };
		int k = 1;

		int[] input2 = { 9, 9 };
		/**
		 * inputs > -100 > 9999 > 9999
		 * 
		 */
//		System.out.print(Arrays.toString(getNumber(input2, k)));
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
	}

	public static int[] getNumber(int[] n, int numberTobeAdded) {

		int[] arr = new int[n.length + 1];
		System.out.println(arr.length);
		for (int i = 0; i < n.length; i++) {
			arr[i + 1] = n[i];
		}
		System.out.println(arr.length);
		int carry = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if ((arr[i]) == 9) {
				arr[i] = 0;
				System.out.println(arr[i] + "  if ");
				carry = numberTobeAdded;

			} else {
				arr[i] = arr[i] + carry;
				System.out.println(arr[i] + " else ");
				carry = 0;
			}
		}
		return arr;
	}

}
