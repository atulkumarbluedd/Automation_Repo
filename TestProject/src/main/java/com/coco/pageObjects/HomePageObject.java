package com.coco.pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;import org.joda.time.tz.ZoneInfoCompiler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.coco.Helpers.pageWait;

import jdk.internal.org.jline.utils.Log;

public class HomePageObject extends pageWait{
	WebDriver driver;
   @FindBy(xpath="//a[text()='BUY NOW']")
   private WebElement buynowButton;
   @FindBy(className = "text-right")
   private WebElement pillowscount;
   @FindBy(tagName = "textarea")
   private WebElement Address;
   @FindBy(className = "cart-checkout")
   private WebElement checkOutBtn;
   
   public HomePageObject(WebDriver driver) {
	   PageFactory.initElements(driver, this);
}
 
   public void clickOnbuynow() {
	   waitforElementVisibiliy(driver, buynowButton);
	   buynowButton.click();
   }
   public void checkOut(String pillocount,String address) {
	 waitforElementVisibiliy(driver, pillowscount);
	   pillowscount.sendKeys(pillocount);
	   assertEquals(pillowscount.getText(), pillocount, "Pillow count is not as expected !!");
	   Address.sendKeys(address);
	   assertEquals(Address.getText(), address,"address enetered is not as expected !!");
	   checkOutBtn.click();
	   Log.info("checkout is done !!!");
   }
   
   
}
