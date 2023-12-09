package SeleniumHandsOn;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Allure;

public class Listeners extends seleniumBaseUtils implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNg.getReporterObject();
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "test is success and passed !!");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test failed !!");
		test.fail(result.getThrowable());
		/* below code is to get driver in case d */
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String failedScr_dstination = null;
		try {
			
			/* add screenshots in extent report  */
			failedScr_dstination = getScreenShotDestination(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(failedScr_dstination, result.getMethod().getMethodName());
			
			
			
			
			/***********************************************************************************************/
			/* below code to add screenshots in the allure report and above is used to add in extent report*/
			
			Allure.addAttachment("Page screenshot on failure", FileUtils.openInputStream(new File(failedScr_dstination)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		 
//		try {
//			String destination =getScreenShotDestination(result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(destination,result.getMethod().getMethodName());
//			 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
