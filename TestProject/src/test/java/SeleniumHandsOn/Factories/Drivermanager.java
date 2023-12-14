package SeleniumHandsOn.Factories;

import org.openqa.selenium.WebDriver;

public final class Drivermanager {
	private Drivermanager() {}
	/**
	 * Thread local class in java helps to create variables that can be read and
	 * written by the same thread. it is easiest way to safeguard static class
	 * variables. we are choosing thread local to help in parallel execution
	 */
	 
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}

	public static void unload() {
		dr.remove();
	}

}
