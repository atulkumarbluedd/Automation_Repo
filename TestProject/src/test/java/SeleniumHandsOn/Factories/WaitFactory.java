package SeleniumHandsOn.Factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFactory {


    static void ExplicitwaitUtil( By locator){
        WebDriverWait wait = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(10));
        wait.until(e -> e.findElement(locator).isEnabled());
//        wait.until(ExpectedConditions.elementToBeClickable(locator));   //older way
    }
}
