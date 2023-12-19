package SeleniumHandsOn.Factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

import SeleniumHandsOn.ConfigSource.CONFIGS;
import SeleniumHandsOn.ConfigSource.constants;
import SeleniumHandsOn.Factories.DriverFactory;
import SeleniumHandsOn.Factories.Drivermanager;

public class seleniumBaseUtils {

	/*
	 * Here we are using alwaysRun is true since we wanted it to be executed every
	 * time if we wont use always run as true then it will not execute at the time
	 * of group execution below method is for configuration so no matter what we
	 * have to execute at every case whether the group is tagged or not
	 * 
	 * @throws IOException
	 *
	 * @throws FileNotFoundException
	 */

	private static int count = 0;

	@BeforeMethod(alwaysRun = true)
	protected void setUp() throws Exception {
		if (Objects.isNull(Drivermanager.getDriver())) {
			WebDriver driver = DriverFactory.initDriver();
			/*
			 * once the driver is set by the above line then in every test case whenever the
			 * driver is required use driver manager always.
			 */
			Drivermanager.setDriver(driver);
			Drivermanager.getDriver().manage().window().maximize();
			Drivermanager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(80000));
		}
	}

	/**
	 * this method is to use take screenshots and return the destination of the
	 * screen shot
	 * 
	 * @param testCaseName
	 * @return
	 * @throws Exception
	 * @throws WebDriverException
	 */

	public static String getScreenShotDestination(String testCaseName) throws WebDriverException, Exception {
		File source = ((TakesScreenshot) Drivermanager.getDriver()).getScreenshotAs(OutputType.FILE);
		String destination = STR."\{System.getProperty("user.dir")}//reports\{testCaseName}.png";
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}


	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		if (Objects.nonNull(Drivermanager.getDriver())) {
			Drivermanager.getDriver().quit();
			Drivermanager.unload();
		}
		count++;
	}

	@AfterSuite
	public void printCount() {
		System.out.println(STR."count is >>>>>>>>>>>>>>>>>>>>>>>> \{count}");
	}

	/**
	 * this method is used to highlight the element in blue color
	 * 
	 * @param element
	 */
	protected static void highlightElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) Drivermanager.getDriver();
		jse.executeScript("arguments[0].setAttribute('style','background:  yellow; border: 10px solid blue;');",
				element);
	}
}
