package SeleniumHandsOn;

import org.testng.ITestResult;
import org.testng.annotations.Test;

public class AllureScreenshotOnfailure extends Listeners {
       @Test
       public void takeScreenShotOnFailure(ITestResult result) {
    	   System.out.println("check listener method on failure");
       }
}
