package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;


public class BrokenLinks {
    @Test
    public void brokenlinks() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/ajax.html");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
        driver.quit();
    }

    private void verifyLinks(String link) throws Exception {
        URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000); // set connection timeout to 3 secs
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(STR."response of the url --> \{httpURLConnection.getResponseMessage()}");
            } else {
                System.out.println(STR."URL is broken \{url}");
            }


    }


}
