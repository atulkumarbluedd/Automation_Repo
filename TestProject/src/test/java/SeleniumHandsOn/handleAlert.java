package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class handleAlert extends seleniumBaseUtils {
	@Test
	public void hanldleAlert() {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement customerbox=driver.findElement(By.name("cusid"));
		WebElement submit_button=driver.findElement(By.name("submit"));
		 highlightElement(customerbox);
		customerbox.sendKeys("53920");
		highlightElement(submit_button);
		submit_button.click();

	}
}
