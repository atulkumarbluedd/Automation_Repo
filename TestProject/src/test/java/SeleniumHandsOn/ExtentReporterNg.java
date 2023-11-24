package SeleniumHandsOn;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	static ExtentReports extent;
    
	public static ExtentReports getReporterObject() {
		String Reortpath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Reortpath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Atul Kumar Arya");
		return extent; 
	}
	
}
