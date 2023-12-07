package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumHandsOn.ConfigSource.constants;

public class HughlightElement extends seleniumBaseUtils {

	@Test
	public void highlightFieldsTest() throws InterruptedException {
		driver.get(constants.IRCTC_URL);
		WebElement searchBox = driver.findElement(By.cssSelector("span.ng-tns-c57-8.ui-autocomplete.ui-widget"));
		seleniumBaseUtils.highlightElement(searchBox);
		Thread.sleep(4000);
	}
}
