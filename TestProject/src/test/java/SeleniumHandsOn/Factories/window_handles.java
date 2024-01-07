package SeleniumHandsOn.Factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class window_handles {
    @Test(description = "using selenium 4 handle window > first open a new window and then switch into that window")
    public void windowHandle(WebDriver driver){
        // Open a new tab in the existing window or tab
        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.switchTo().newWindow(WindowType.TAB);

        /** switch to new window **/
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

}
