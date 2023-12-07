package SeleniumHandsOn;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import bsh.Capabilities;
import io.appium.java_client.remote.MobileBrowserType;

public class sampleTest {
	@Test
	public void sma() throws MalformedURLException, InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "100");
		chromeOptions.setCapability("platformName", "linux");

		// Showing a test name instead of the session id in the Grid UI
		chromeOptions.setCapability("se:name", "My simple test");
		// Other type of metadata can be seen in the Grid UI by clicking on the
		// session info or via GraphQL
		chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), chromeOptions);
		driver.get("http://www.amazon.com");
		Thread.sleep(80000);
		driver.quit();
	}

	@Test(description = "below test is to run tests in selenium grid")
	public void executeTestsIn_selenium_grid() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
		driver.get("https://google.com");
		System.out.println("title is >> " + driver.getTitle());

		Thread.sleep(70000);
		driver.quit();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
		driver.get("https://google.com");
		System.out.println("title is >> " + driver.getTitle());
		Thread.sleep(100000);
		driver.get("https://google.com");
		driver.quit();
	}
}
