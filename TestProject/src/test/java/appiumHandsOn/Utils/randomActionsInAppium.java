package appiumHandsOn.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.mockito.internal.matchers.And;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.devtools.v85.deviceorientation.DeviceOrientation;
import org.testng.annotations.Test;

public class randomActionsInAppium {
    AndroidDriver driver = null;
    @Test(description = "get orientation or rotate into specific orientation !!")
    public void rotateDevice(){
        /**
         * here ScreenOrientation is enum
         */
        ScreenOrientation orientaiton = driver.getOrientation();
        System.out.println(orientaiton.value());
        System.out.println(orientaiton.compareTo(ScreenOrientation.LANDSCAPE));
        /* rotate method is present in SupportsRotation interface which has 2 default rotate methods*/
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(new DeviceRotation(0,20,90)); /** this will take in which cordinates you want to rotate the device**/
    }
    @Test(description = "hide keyBoard")
    public void hideKey_board(){

        /** HidesKeyboard is an inteface which has hidekeyboard  default method*/
        driver.hideKeyboard();
    }
    @Test(description = "press home button")
    public void press_home(){
        /**
         *  presskey and longpresskey are default method under the PressesKey interface which
         *  under java client keyEvent is class which takes AndroidKey enum as argument
         */
        driver.longPressKey(new KeyEvent(AndroidKey.HOME));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.PAGE_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.MEDIA_PLAY));
        driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_UP));
        driver.pressKey(new KeyEvent(AndroidKey.POWER));
    }


}
