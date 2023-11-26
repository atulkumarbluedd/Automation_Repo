package SeleniumHandsOn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.dockerjava.api.model.Config;

import SeleniumHandsOn.ConfigSource.CONFIGS;
import SeleniumHandsOn.ConfigSource.constants;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class seleniumBaseUtils {
	static WebDriver driver;
	static String URL = constants.URL;

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
	@SuppressWarnings("unlikely-arg-type")
	@BeforeClass(alwaysRun = true)
	public void initDriver() throws FileNotFoundException, IOException {

		String browser = propertyReader(CONFIGS.BROWSER_NAME);
		String runMode = propertyReader(CONFIGS.RUNMODE);

		if (Objects.isNull(driver)) {
			if (browser.equalsIgnoreCase("chrome")) {
				if (runMode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(browser);
					driver = new RemoteWebDriver(new URL(propertyReader(CONFIGS.GRID_URL)), cap);
				} else
					driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

		} else {
			driver = new ChromeDriver();
			System.out.println("Launching chrome browser as no browser parameter came");

		}
		driver.manage().window().maximize();
	}

	/**
	 * this method is to use take screenshots and return the destination of the
	 * screen shot
	 * 
	 * @param testCaseName
	 * @return
	 * @throws IOException
	 */

	public static String getScreenShotDestination(String testCaseName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}

	/**
	 * below method is used to get all the properties one time stored in the map
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public HashMap<String, String> propertyReader() throws FileNotFoundException, IOException {
		String File_Path = System.getProperty("user.dir") + "\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(File_Path);
		prop.load(fis);

		HashMap<String, String> map = new HashMap<String, String>();
		for (Entry<Object, Object> entry : prop.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}

		return map;

	}

	/**
	 * method is used to get single property of the key
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String propertyReader(CONFIGS key) throws FileNotFoundException, IOException {
		String File_Path = System.getProperty("user.dir") + "\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(File_Path);
		prop.load(fis);

		return prop.getProperty(key.toString());

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
