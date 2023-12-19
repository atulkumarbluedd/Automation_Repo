package SeleniumHandsOn;

import SeleniumHandsOn.ConfigSource.CONFIGS;
import SeleniumHandsOn.ConfigSource.constants;
import SeleniumHandsOn.Factories.Drivermanager;
import SeleniumHandsOn.Factories.PropertyUtils;
import SeleniumHandsOn.Factories.seleniumBaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class launchChrome extends seleniumBaseUtils {

	@Test(description = "Test chrome launching", groups = { "smoke" })
	public  void chromeConfiguration() throws Exception {

		Drivermanager.getDriver().get(constants.getIRCTC_URL());
		Drivermanager.getDriver().manage().window().maximize();
        Assert.assertTrue(true);
		/*
		 * below parameter is used from command line when we use below command mvn test
		 * -PRegression -DnameOFme="atulKumarArya"
		 */
		String temp = System.getProperty("nameOFme");
		System.out.println(temp);
		System.out.println(PropertyUtils.get(CONFIGS.AUTHOR));

	}

	@Test(description = "Test chrome launching with assertion failed !!", groups = {"smoke"})
	public void aLaunchChrome2() throws IOException {
		 
		Drivermanager.getDriver().get("https://demo.midtrans.com/");
		Drivermanager.getDriver().manage().window().maximize();
        Assert.assertTrue(true);
	}
	
	@Test(description = "launch chrome and launch chrome browser ", groups= {"sanity"})
	public void launchesAmazon() {
		Drivermanager.getDriver().get("https://amazon.com");
        assertFalse(false);
	}
}
