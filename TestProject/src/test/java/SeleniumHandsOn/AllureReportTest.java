package SeleniumHandsOn;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumHandsOn.Factories.Drivermanager;

public class AllureReportTest {
	/**
	 * to do ->> add allure testng dependency 
	 * download allure binary and extract, and add path till bin folder in the path variables 
	 * plugin in jenkins u will get a seperate option click on allure it will give
	 * you the report
	 * to run report locally in the jetty server
	 * go to the project location and run command >> allure serve
	 */
	@Test(description = "Run a test and generate allure report")
	public void allureTest() {
		Drivermanager.getDriver().get("https://allure.com");;
		
		System.out.println("hello");
		Assert.assertEquals(false, true);
	}
}
