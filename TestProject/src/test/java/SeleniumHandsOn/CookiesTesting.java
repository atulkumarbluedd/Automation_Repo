package SeleniumHandsOn;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesTesting {
    /**
     * A cookie is a small piece of data that is sent from a website and stored in your computer.
     * Cookies are mostly used to recognise the user and load the stored information.
     */
    WebDriver driver = new ChromeDriver();

    @Test(description = "Launch browser and delete cookies and set the specific screen size !!")
    public void launch_browser_deleteCookies_Specific_size() throws InterruptedException {

        Thread.sleep(5000);
        driver.manage().deleteAllCookies();

        /** To set the size of the window**/
        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(4000);

        /** To set the position of the window**/
        Point point = new Point(250, 250);
        driver.manage().window().setPosition(point);

        Thread.sleep(4000);
        driver.get("https://amazon.com");
    }

    @Test(description = "Add new cookie")
    public void addNewCookie() throws Exception {

        Thread.sleep(5000);
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();
        driver.quit();

    }

    @Test(description = "get all cookies")
    public void getAllCookies() {
        Set<Cookie> allCookies = driver.manage().getCookies();
        allCookies.forEach(e -> System.out.println(e.getName() + " :: " + e.getValue() + " ::" + e.getDomain() + "::" + e.getPath() + " :: " + e.getExpiry() + ":: " + e.isHttpOnly() + " :: " + e.isSecure()));

    }

    @Test(description = "get named cookie and delete cookie")
    public void getNamedCookie() {
        /** get cookie name as foo**/
        Cookie cookie = driver.manage().getCookieNamed("foo");
        // delete all cookie
        driver.manage().deleteAllCookies();
        // delete cookie using cookie object
        driver.manage().deleteCookie(cookie);
        // delete named cookie
        driver.manage().deleteCookieNamed("foo");

    }
}
