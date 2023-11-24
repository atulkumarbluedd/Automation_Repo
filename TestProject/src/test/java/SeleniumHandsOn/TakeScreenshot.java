package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshot {
	WebDriver driver;

	@Test(description = "take screenshot for full page.")

	public void ScreenShotFullPage() throws IOException {

		driver = new ChromeDriver();
		System.out.println("Launching chrome browser");
		driver.get("https://demo.midtrans.com/");

		driver.manage().window().maximize();

		/* full page screenshot */
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\homepage.png"));

	}

	@Test(description = "take screenshot of perticular element or portion of the page")
	public void takeScreenShotOfWebElement() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://demo.midtrans.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
		WebElement element = driver.findElement(By.xpath("//*[text()='Midtrans Pillow']"));
		File src = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\takeScreenShotOfWebElement.png"));

	}
	 
}
