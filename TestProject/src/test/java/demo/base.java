package demo;

import org.testng.annotations.BeforeTest;

import groovy.beans.PropertyReader;

public class base {
	 String name;
   @BeforeTest
   public void executor() {
	     
	    this.name="454";
   }
}
