package SeleniumHandsOn.Factories;

import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import SeleniumHandsOn.ConfigSource.CONFIGS;

public class DriverFactory {
	private static WebDriver driver = null;

	public static WebDriver initDriver() throws Exception {

		String browser = PropertyUtils.get(CONFIGS.BROWSER_NAME);
		String runMode = PropertyUtils.get(CONFIGS.RUNMODE);
		/**
		 * here we are checking the driver as null because some times people might use
		 * below sentence explicitly in the test case without checking @beforeclass
		 * or @beforeMethod or checking in the base class driver =
		 * DriverFactori.getDriver();
		 */
		if (Objects.isNull(Drivermanager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				if (runMode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(browser);
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(CONFIGS.GRID_URL)), cap);
				} else
					driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				if (runMode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(browser);
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(CONFIGS.GRID_URL)), cap);
				} else
					driver = new FirefoxDriver();
			}

		} else {
			driver = new ChromeDriver();
			System.out.println("Launching chrome browser as no browser parameter came");

		}

		return driver;
	}
}