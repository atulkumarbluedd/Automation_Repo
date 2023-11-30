package SeleniumHandsOn.Factories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import SeleniumHandsOn.seleniumBaseUtils;
import SeleniumHandsOn.ConfigSource.CONFIGS;

public class DriverFactori extends seleniumBaseUtils {

	public static WebDriver getDriver() throws FileNotFoundException, IOException {
		WebDriver driver = null;
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
				if (runMode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(browser);
					driver = new RemoteWebDriver(new URL(propertyReader(CONFIGS.GRID_URL)), cap);
				} else
				driver = new FirefoxDriver();
			}

		} else {
			driver = new ChromeDriver();
			System.out.println("Launching chrome browser as no browser parameter came");

		}
		driver.manage().window().maximize();
		return driver;
	}
}