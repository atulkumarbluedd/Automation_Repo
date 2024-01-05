package appiumHandsOn;

import appiumHandsOn.Pages.ios.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.xmlbeans.GDuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

import static java.lang.System.getProperty;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertEquals;

public class ios_utills {


    /**
     * for locating the elements we are using appium inspector for android and ios both
     *  prdicate string examples
     *  label CONTAINS \"JOHN\"
     *  label BEGINSWITH \"SEEMA\"
     *  label ENDSWITH \"ROHAN\"
     *
     *  class chain examples need to check same as xpath. but here we are starting with double star >> ** "/tag[label=="value"]"
     *
     *
     /*/

    /**
     * in ios we have one predicate string and ios class chain  locator which is not present in the android
     *
     * @param driver
     * @param locator
     * @throws Exception
     */
    @Test(description = "basic app launching for android device  ")
    public void sample(AndroidDriver driver, By locator)  throws  Exception{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("path of the app")
                .setDeviceName("Pixel 7 pro")
                .setAppPackage("")
                .setAppActivity("")
                .setAppWaitActivity("package_name");

        driver = new AndroidDriver(new URL("http://127.0.0.0:4723"),options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
       wait.until(visibilityOfElementLocated(locator));
       wait.until(elementToBeClickable(locator));
      wait.until(elementToBeSelected(locator));

    }
    private IOSDriver driver;

    @BeforeClass
    public void setupClass () throws MalformedURLException {
        final var option = new XCUITestOptions();
        option.setApp (Path.of (getProperty ("user.dir"), "src/test/resources/wdio-demo.app.zip")
                        .toString ())
                .setPlatformVersion ("17.0")
                .setDeviceName ("iPhone 15");
        this.driver = new IOSDriver (new URL ("http://localhost:4723/"), option);
        this.driver.manage ()
                .timeouts ()
                .implicitlyWait (ofSeconds (1));
    }

    @AfterClass
    public void teardownClass () {
        this.driver.quit ();
    }

    @Test
    public void testSignUp () {
        final var signUpPage = new SignUpPage(this.driver);
        final var actualMessage = signUpPage.doSignUp ("admin@gmail.com", "Admin@1234");

        assertEquals (actualMessage, "You successfully signed up!");
    }
}
