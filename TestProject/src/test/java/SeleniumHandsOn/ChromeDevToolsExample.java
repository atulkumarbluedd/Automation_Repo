package SeleniumHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.fetch.Fetch;
import org.openqa.selenium.devtools.v116.network.Network;

import java.util.Optional;

/**
 * here we have to add devtools dependency then it will work
 */
public class ChromeDevToolsExample {
    public static void main(String[] args) {

//        // Create ChromeDriver instance
//        WebDriver driver = new ChromeDriver();
//
//        // Create DevTools instance
//        DevTools devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.createSession();
//
//        // Enable Network and Fetch domains
////        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
////        devTools.send(Fetch.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Add event listeners for network events
//        devTools.addListener(Network.requestWillBeSent(), request -> {
//            System.out.println("Request URL: " + request.getRequest().getUrl());
//        });
//        devTools.addListener(Network.responseReceived(), response -> {
//            System.out.println("Response URL: " + response.getResponse().getUrl());
//        });
//        devTools.addListener(Network.dataReceived(), data -> {
//            System.out.println("Data received for URL: " + data.getRequestId());
//        });
//
//        // Perform actions on the web page
//
//        // Fetch data from the network
////        devTools.send(Fetch.enable(Optional.empty(), Optional.empty(), Optional.empty()));
////        devTools.send(Fetch.takeResponseBodyAsStream("requestId"));
//
//        // Perform geolocation testing
////        devTools.send(Network.setGeolocationOverride(37.7749, -122.4194, 100));
//
//        // Perform other actions using the DevTools APIs
//
//        // Close the WebDriver and DevTools sessions
//        driver.quit();
//        devTools.close();
    }
}
