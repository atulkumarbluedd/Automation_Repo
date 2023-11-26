package SeleniumHandsOn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.mongodb.connection.Stream;

import SeleniumHandsOn.ConfigSource.CONFIGS;

public class ExecuteTestInDocker extends seleniumBaseUtils{

	/* make sure we have taken runmode as remote in config.property file */
	@Test(description = "Check to run one test case in docker !!")
	public void sampleDockerTest() throws IOException {

		DesiredCapabilities cap = new DesiredCapabilities();

		String File_Path = ".\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(File_Path);
		prop.load(fis);

		 
		;

	}
}
