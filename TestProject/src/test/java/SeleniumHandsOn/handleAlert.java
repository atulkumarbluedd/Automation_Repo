package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import SeleniumHandsOn.Factories.seleniumBaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumHandsOn.Factories.Drivermanager;

public class handleAlert  {
	@Test(description = "Test case to handle alert", groups= {"smoke"})
	public void hanldleAlert() {
//		Drivermanager.getDriver().get("https://demo.guru99.com/test/delete_customer.php");
//		WebElement customerbox=Drivermanager.getDriver().findElement(By.name("cusid"));
//		WebElement submit_button=Drivermanager.getDriver().findElement(By.name("submit"));
//		 highlightElement(customerbox);
//		customerbox.sendKeys("53920");
//		highlightElement(submit_button);
//		submit_button.click();
//        assertFalse(false);


	}
	@Test
	public void test(){
		String str1 = "rkqodlw";
		String str2 = "world";
		if (canMakeStr2(str1, str2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static int MAX = 256;

	static boolean canMakeStr2(String str1, String str2)
	{
		// Create a count array and count frequencies
		// characters in str1.
		int[] count = new int[MAX];
		char []chArray1 = str1.toCharArray();
		for (int i = 0; i < chArray1.length; i++)
			count[chArray1[i]]++;

		// Now traverse through str2 to check
		// if every character has enough counts

		char []str4 = str2.toCharArray();
		for (int i = 0; i < str4.length; i++) {
			if (count[str4[i]] == 0)
				return false;
			count[str4[i]]--;
		}
		return true;
	}
}
