package SeleniumHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchChrome {
 
	
	@Test(description = "Test chrome launching")
	public void cromeTest() {
		
		   WebDriver driver = new ChromeDriver();
		   System.out.println("Launching chrome browser");
		   driver.get("https://demo.midtrans.com/");
		   
		
	}
}
