package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumHandsOn.Factories.Drivermanager;

public class handleAlert extends seleniumBaseUtils {
	@Test
	public void hanldleAlert() {
		Drivermanager.getDriver().get("https://demo.guru99.com/test/delete_customer.php");
		WebElement customerbox=Drivermanager.getDriver().findElement(By.name("cusid"));
		WebElement submit_button=Drivermanager.getDriver().findElement(By.name("submit"));
		 highlightElement(customerbox);
		customerbox.sendKeys("53920");
		highlightElement(submit_button);
		submit_button.click();
		assertEquals(false, false);

	}
}
