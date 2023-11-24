package SeleniumHandsOn;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumUtils {
	static WebDriver driver;

	 
	@BeforeClass
	public void configureChrome() {
		 driver = new ChromeDriver();
		System.out.println("Launching chrome browser");
		driver.get("https://demo.midtrans.com/");

		driver.manage().window().maximize();
	}

	public static String getScreenShotDestination(String testCaseName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}
}
