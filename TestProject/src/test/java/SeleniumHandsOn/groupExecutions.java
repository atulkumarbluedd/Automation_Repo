package SeleniumHandsOn;

import java.io.IOException;

import SeleniumHandsOn.Factories.seleniumBaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumHandsOn.Factories.Drivermanager;

public class groupExecutions extends seleniumBaseUtils {

	/**
	 * for more details follow below link
	 * https://testgrid.io/blog/testng-groups/#:~:text=Groups%20of%20Groups%20in%20TestNG,-In%20TestNG%2C%20groups&text=Using%20these%20MetaGroups%20you%20can,%E2%80%9D%20and%20%E2%80%9Csearch2%E2%80%9D%20respectively.
	 * 
	 * @throws IOException
	 */

	@Test(description = "Test chrome launching", groups = { "smoke" })
	public void groupExecution() throws IOException {
		System.out.println("Launching chrome browser");
		Drivermanager.getDriver().get("https://demo.midtrans.com/");

		Drivermanager.getDriver().manage().window().maximize();
		Assert.assertEquals(true, true);

	}

	@Test(description = "Test chrome launching with assertion failed !!", groups = { "sanity" })
	public void LaunchChrome2() throws IOException {
		System.out.println("Launching chrome browser");
		Drivermanager.getDriver().get("https://demo.midtrans.com/");

		Drivermanager.getDriver().manage().window().maximize();
		Assert.assertEquals(true, true);

	}
}
