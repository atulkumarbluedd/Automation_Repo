package SeleniumHandsOn;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.lang.Nullable;

import SeleniumHandsOn.ConfigSource.constants;
import SeleniumHandsOn.Factories.Drivermanager;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

public class launchChrome extends seleniumBaseUtils {

	 
	@Test(description = "Test chrome launching", groups = { "smoke" })
	public  void chromeConfiguration() throws IOException {
		 
		Drivermanager.getDriver().get(constants.getIRCTC_URL());
		Drivermanager.getDriver().manage().window().maximize();
		Assert.assertEquals(true, true);
		/*
		 * below parameter is used from command line when we use below command mvn test
		 * -PRegression -DnameOFme="atulKumarArya"
		 */
		String temp = System.getProperty("nameOFme");
		System.out.println(temp);

	}

	@Test(description = "Test chrome launching with assertion failed !!", groups = {"smoke"})
	public void aLaunchChrome2() throws IOException {
		 
		Drivermanager.getDriver().get("https://demo.midtrans.com/");

		Drivermanager.getDriver().manage().window().maximize();
		Assert.assertEquals(true, true);

	}
	
	@Test(description = "launch chrome and launch chrome browser ", groups= {"sanity"})
	public void launcheAmazon() {
		Drivermanager.getDriver().get("https://amazon.com");
		assertEquals(false, false);
	}
}
