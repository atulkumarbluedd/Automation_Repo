package SeleniumHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchChrome {
 
	
	@Test(description = "Test chrome launching")
	public void cromeTest() {
		   WebDriverManager.getInstance("chrome");
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://demo.midtrans.com/");
		
	}
}
