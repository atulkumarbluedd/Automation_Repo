package SeleniumHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class ExtentReportTest {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		String Reortpath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Reortpath);
		reporter.config().setReportName("Atul's First report for ");
		reporter.config().setDocumentTitle("Test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Atul Kumar Arya");

	}

	@Test(description = "this test is to generate a sample extent Report > prereuisite is to import the extent report jar only")
	public void sampleTest() {

		/*
		 * This method is to give knowledge to the extent report that we have to include
		 * in the report
		 */
		
		ExtentTest test = extent.createTest("initial demo");

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		 
		 /* to fail it explicitly !!*/
		test.fail("result doesn't match !!");

		extent.flush();
	}
}
