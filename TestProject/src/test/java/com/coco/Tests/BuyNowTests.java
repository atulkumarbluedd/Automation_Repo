package com.coco.Tests;

import java.time.Duration;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.coco.pageObjects.HomePageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class BuyNowTests {
	public Supplier<String> messageSupplier=()->null;	/*read about this*/
   @Test(description = "Happy Flow")
   
   public void buyNowHappyFlow() throws InterruptedException {
	    
	   WebDriver driver = new FirefoxDriver();
	   driver.get("https://demo.midtrans.com/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
	   HomePageObject h= new HomePageObject(driver);
	   h.clickOnbuynow();
	  
	   Thread.sleep(10000);
	  
	   int size=driver.getWindowHandles().size();
	   System.out.println(size+">>>>>>>>");
		 
	   h.checkOut("1000", "167 j.p colony govind nagar bangalore");
	  
	   
   }
}
