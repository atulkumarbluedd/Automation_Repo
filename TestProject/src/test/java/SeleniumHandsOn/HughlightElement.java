package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumHandsOn.ConfigSource.constants;
import SeleniumHandsOn.Factories.Drivermanager;
import dev.failsafe.internal.util.Assert;

public class HughlightElement extends seleniumBaseUtils {

	@Test(description = "Launch irctc website in chrome and highlight element", groups= {"smoke", "sanity"})
	public void highlightFieldsTest() throws InterruptedException {
		Drivermanager.getDriver().get(constants.getIRCTC_URL());
		WebElement searchBox = Drivermanager.getDriver().findElement(By.cssSelector("span.ng-tns-c57-8.ui-autocomplete.ui-widget"));
		seleniumBaseUtils.highlightElement(searchBox);
		System.out.println();
		 
		assertEquals(false, false);
	}
}
