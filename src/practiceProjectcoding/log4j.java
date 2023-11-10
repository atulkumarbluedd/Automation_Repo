package DataStructure;

public class log4j {
	/*
	 * types of log
	 * 1. info 
	 * 2. warn
	 * 3. error
	 * 4. fatal
	 * Steps 1st add lg4j jars
	 * now create src/main.resources folder
	 * then create file	i.e log4j.properties // compulsory give the name
	 * Just paste the property in this file
	 * **********************
	 * file specification |||||||||||||||
	 * ******************* 
	 * Root catageory ::log4j.rootcatageory=debug, console, file 
	 * (where we want to generate the logs)
	 * consoleAppender is used to write in the root catageory i.e console
	 * conversionpattern:: which date format want to use for generating the file
	 * Rollingfileappender : it is used to write logs in the file.
	 * file ="name for the file"
	 * size, maxbackupindex= used to create a backup after the size is done
	 * pattern layout:: iso8601 is a stndard configuration that we use.
	 * 
	 *  Append = false
	 *  when we want to remove last logs and then wanted to create only the new logs.
	 *  Append = true
	 *  append with the previous logs
	 *  ************************************
	 *  Generate own logs
	 *  ************************************
	 *  Logger log= Logger.getLogger(Logintest.class);
	 *  now use in the test like below
	 *  log.info("launching the chrome")
	 *  log.warn("this is just a warning");
	 *  log.fatal("hwy this is fatal error message") ;
	 *  log.debug("hey this is debug method")
	 *  *******************************************
	 *  How to execute failed test cases for the 3 times and then if it still failes then i will mark as a failed.
	 *  ********************************************
	 *  create retryAnalyzer class and implement it with the Iretryanalyzer interface
	 *  int count=0;
	 *  int retryLimit=3;
	 *  public boolean retry(iTestresult result)
	 *
	 *  {
	 *  if(count<retryLimit)
	 *  {
	 *  counter++;
	 *  return true;
	 *  }
	 *  return false;
	 *  }
	 *   
	 *   // now at the test level do the below
	 *   @Test(retryAnalyzer=Analyzer.retryAnalyzer.class)
	 *   {
	 *   }
	 *   
	 *   problem :: if you have 100 testcases then for all the test
	 *    cases you have to copy the lines just before the test case
	 *    
	 *   
	 *   ************************************************************
	 *                           Solution for the Above
	 *   ************************************************************
	 *   create one class MyTransformer and then implements it with IAnnotationTranformer
	 *   
	 *   Now create one transform method which came from IAnnotationTranformer like below
	 *   FYI testNg listener are based on reflection API
	 *   @override
	 *   public void transform(ItestAnnotation  annotation, Class testclass, Constructor testconstructor, Method testmethod)
	 *   {
	 *      annotation.setRetryAnalizer(RetryAnalizer.class)
	 *   }
	 *   create testng.xml file and then add listners tag
	 *   <listeners>
	 *   <listener class-name="Analyzer.MyTransformer"/>
	 *   </listeners>
	 * 
	 *  now for every test case this will execute but you need to execute testNg.xml file 
	 *  Above lintener will execute only failed testcases for the 3 time and then fail the test
	 *  
	 * 
	 * 
	 * */

}
