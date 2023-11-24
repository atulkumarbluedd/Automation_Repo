package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class launchChrome extends seleniumUtils{

	 

	@Test(description = "Test chrome launching")
	public void chromeConfiguration() throws IOException {
		System.out.println("Launching chrome browser");
		driver.get("https://demo.midtrans.com/");

		driver.manage().window().maximize();
		Assert.assertEquals(true, true);

	}
	@Test(description = "Test chrome launching with assertion failed !!")
	public void LaunchChrome2() throws IOException {
		System.out.println("Launching chrome browser");
		driver.get("https://demo.midtrans.com/");

		driver.manage().window().maximize();
		Assert.assertEquals(true, false);

	}
}
