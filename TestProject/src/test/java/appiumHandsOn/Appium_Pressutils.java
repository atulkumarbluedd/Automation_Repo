package appiumHandsOn;

import com.coco.Tests.sample;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import javax.naming.Context;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Appium_Pressutils {
    AndroidDriver driver = null;
    WebElement element = null;

    /*
     how to load apk using apk classLoader
     */
    public static void main(String[] args) {
        /* another way of providing path of the apk */
        ClassLoader loader = sample.class.getClassLoader();
        File file = new File(loader.getResource("path_of_apk_File").getFile());
        String apkPath = file.getAbsolutePath();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setPlatformVersion("8.1")

                .setAutomationName("UIAutomator2")
                .setDeviceName("emulator212")

                .setAppPackage("lklsdlsj")
                .setAppActivity("hshhdsaj")

                .setApp(apkPath)
                .setNoReset(false);


    }

    /**
     * run appium server programatically
     */
    static {
        String nodeJSMainPath = "C:\\Users\\cmash\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
        String logFilePath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\logs\\log2.txt";
        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder.withAppiumJS(new File(nodeJSMainPath))
                .usingDriverExecutable(new File(nodeExePath))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(logFilePath))
                .withIPAddress("127.0.0.1");

        AppiumDriverLocalService server = AppiumDriverLocalService.buildService(builder);
        server.start();
    }

    @Test(description = "long press using touch actions class ")
    public void longPress_new() {

        Point location = element.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(input, 0);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y)); /* 1 ->  here we want for how long we wanted to be pressed*/
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(sequence));
    }

    @Test(description = "scroll and swipe")
    public void swipe_scroll() {

    }

    @Test(description = "launch chrome browser in app  ")
    public void app_chromeLaunch() {
        /* if you are facing issue regarding chrome driver latest version in mobile chrome
         * use this command it might work
         * appium --allow-insecure chromedriver_autodownload
         * use browsername capability as chrome nothing to change it will work */
    }

    @Test(description = "switch b.w native and hybrid app")
    public void hbybrid_app_chrome() {
        System.out.println("current context :: " + driver.getContext());
        Set<String> contexts = driver.getContextHandles();
        driver.context("NATIVE_APP"); // for native app
        /* to switch into web view */
        driver.context("WEBVIEW_packageName");


    }

    @Test(description = "scroll till element is not visible")
    public void scroll_till_element_not_shown() throws InterruptedException {
        int size = 0;
        By elementToFind = null;
        while (size == 0) {
            System.out.println("Element Not Found ... Keep Scrolling");
            new scroll_swipe().scroll("RIGHT", 0.5);
            Thread.sleep(2000L);
            size = driver.findElements(elementToFind).size();
            if (size == 1) {
                System.out.println("Found Element");
                size++;
                break;
            }
        }

    }

}
