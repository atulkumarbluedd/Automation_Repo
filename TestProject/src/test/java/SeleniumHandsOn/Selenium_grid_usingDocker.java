package SeleniumHandsOn;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Selenium_grid_usingDocker {

	/**
	 * here prerequisite us to install every corresponding version image from docker
	 * 
	 * @param browserName
	 * @param version
	 * @throws Exception
	 */
	@Test(description = "Execute tests in parallel with different versions in different browers using selenium hub and node", dataProvider = "getData")
	public void executeTestsIn_selenium_grid_using_dataProvider(String browserName, String version) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browserName);
//		cap.setVersion(version);

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://google.com");
		System.out.println("title is >> " + driver.getTitle());
		 
		Thread.sleep(70000);
		driver.quit();
	}

	@DataProvider(parallel = true)
	public Object[][] getData() {
		return new Object[][] { { "chrome", "119" }, { "firefox", "400" }, { "chrome", "119" }, { "firefox", "119" } };
	}
}
