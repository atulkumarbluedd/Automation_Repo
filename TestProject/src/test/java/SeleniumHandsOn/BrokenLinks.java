package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


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
        // skip null or empty hrefs
        if (link == null || link.trim().isEmpty()) {
            System.out.println("Skipping empty href");
            return;
        }
        // only check http or https links
        if (!(link.startsWith("http://") || link.startsWith("https://"))) {
            System.out.println("Skipping non-http(s) link: " + link);
            return;
        }

        URL url = new URL(link);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(3000); // set connection timeout to 3 secs
        httpURLConnection.connect();

        int code = httpURLConnection.getResponseCode();
        if (code == 200) {
            System.out.println("response of the url --> " + httpURLConnection.getResponseMessage());
        } else {
            System.out.println("URL is broken " + url + " (HTTP response code: " + code + ")");
        }


    }


}
