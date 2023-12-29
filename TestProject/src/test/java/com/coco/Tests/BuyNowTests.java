package com.coco.Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BuyNowTests {
	public Supplier<String> messageSupplier=()->null;	/*read about this*/
   @Test(description = "Happy Flow")
   
   public void buyNowHappyFlow() throws InterruptedException {
//
//
	     Supplier<List<String>> messageSupplier=()->List.of("same","ron");
	   List<String> s=messageSupplier.get();
	   System.out.println(s);
   }
}
