package SeleniumHandsOn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import SeleniumHandsOn.Factories.seleniumBaseUtils;
import org.testng.annotations.Test;

public class ExecuteTestInDocker extends seleniumBaseUtils {

	/* make sure we have taken runmode as remote in config.property file */
	@Test(description = "Check to run one test case in docker !!")
	public void sampleDockerTest() throws IOException {
		String File_Path = ".\\resources\\config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(File_Path);
		prop.load(fis);
	}
}
