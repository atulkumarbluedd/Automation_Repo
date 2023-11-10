package DataStructure;

public class allureReport {
	/****** Allure report
	 * 1. aspect j. property
	 * 2. add allure maven dependency
	 * 3. add compiler plugin
	 * 4. add surefireplugin -- undr suitestngxmlFiles place the path for the testng.xml file
	 * 5. add java agent in surefireplugin 
	 * 6. add aspect jWeaver plugin after the javaAgent.
	 * 7. Now do maven update 
	 * 8. under @test(description="it is for the login functionality")// this is testNg description it is not necessary to write
	 * 9. @severity(SeverityLevel.NORMAL) i.e BLOCKER, CRITICAL, TRIVIAL, MINOR 
	 * 10. @Description(" add descrition here ")
	 * 11. @Story(" here we can add the story details")
	 * 12. @step("verify signup link") // make habit of adding this before every @test.
	 * 13. @Step("Login with username : {0}  and password : {1}") // we can append it with every parameter.
	 * 14. "allure serve allure-results" used to run from the cmd to generate allure report
	 * **************************************************************************************************
	 *                     Add attachment for the screenshot for the fail test cases
	 * **************************************************************************************************
	 *  create testallureListener and implement with the itestlistener
	 *  
	 *  // @attachment annotation is given by allure 
	 *  @Attachment(value="page screenshot", type="image/png")
	 *  public byte[] saveScreenshot(webdriver driver)
	 *  {
	 *    return ((Takescreenshot)driver).getScreenshotAs(OutputType.BYTES);
	 *  }
	 *  
	 *  Now use this method like below
	 *   onTestfailure(ItestResult result)
	 *  {
	 *  // save a log on Allure  
	 *  savetextLog(result.getMethod().getName())
	 *  }
	 * 
	 * 
	 * 
	 *  
	 * And for using this listener we have to mention it on the testng.xml and also for the testcase also 
	 * like for @test we use @Listeners({TestAllureListener.class})
	 * 
	 * *********************************************************************************************************
	 *                              extent report
	 * *********************************************************************************************************
	 *   
	 *   
	 *   
	 *   
	 * 
	 * */
	

}
