package appiumHandsOn;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class scroll_swipe {
    static AppiumDriver driver;

    /**
     * actual repo  ->  https://github.com/sheetalrepo/AppiumTest/blob/master/src/test/java/demo/helper/Utils.java#L88
     */
     /* this method is same as longPress method only here we have to provide start and end point*/
    protected static void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }


    /*
     *
     * If scrollRatio = 0.8 then page will scroll fast
     * If scrollRatio = 0.2 then page will scroll very less
     *
     * If user want to scroll page in DOWN direction
     * Then scroll mobile screen starting from Bottom to Top (B to A)
     *
     * If user want to scroll page in RIGHT direction
     * Then scroll mobile screen starting from Right to Left (N to M)
     *
     * Assume Screen size = 50(x value) by 100(y value)
     * midpoint of screen will be 50*0.5 & 100*0.5 i.e. (25,50)
     *        A
     * M                N
     *        B
     */
    public static void scroll(String pageDirection, double scrollRatio) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }

        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen Size = " + size);
        System.out.println("");

        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
        int a = 0;
        int b = 0;

        try {
            /* below a and b are not required this is just to get the idea*/
            a = (int) (midPoint.x * scrollRatio);
            b = (int) (midPoint.y * scrollRatio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio); // 50 + 25        B
        int top = midPoint.y - (int) (midPoint.y * scrollRatio); // 50 - 25           A
        int left = midPoint.x - (int) (midPoint.x * scrollRatio); // 25 - 12.5         M
        int right = midPoint.x + (int) (midPoint.x * scrollRatio); // 25 + 12.5        N

        System.out.println("Midpoint: " + midPoint);

        System.out.println("Midpoint x: " + midPoint.x);
        System.out.println("a: " + a);

        System.out.println("Midpoint y: " + midPoint.y);
        System.out.println("b: " + b);

        System.out.println("");
        System.out.println("Bottom: " + bottom);
        System.out.println("Top: " + top);
        System.out.println("Right: " + right);
        System.out.println("Left: " + left);
        System.out.println("--------------------");

        if (pageDirection == "UP") {
            //Swipe Top to bottom, Page will go UP
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (pageDirection == "DOWN") {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (pageDirection == "LEFT") {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            //RIGHT
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    public void swipeMe() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Swipe")).click();
        Thread.sleep(4000);
        //Move page towards Right
        scroll("RIGHT", 0.5);
        Thread.sleep(2000);
        scroll("RIGHT", 0.5);
        Thread.sleep(2000);
        scroll("LEFT", 0.5);
        Thread.sleep(2000);
        scroll("DOWN", 0.8);
        Thread.sleep(2000);
        scroll("UP", 0.8);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        System.out.println("---------- Ru" +
                "n Started ----------");
        UiAutomator2Options options = new UiAutomator2Options();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
                new ChromeOptions());

        scroll_swipe obj = new scroll_swipe();
        obj.swipeMe();
        System.out.println("---------- Run Finished ----------");
    }
}
