package SeleniumHandsOn.ConfigSource;

public final class constants {
	/**
	 * private constructor is to restrict the user to create object and class is
	 * final because we do'nt want the class to be extended by another class the
	 * intention is test case can extend only the base class only Note :: here we
	 * will not store driver url as if the manual tester will come then he will not
	 * install all code. we will simply give the end user a excel file and he will
	 * simply run the command and execute the test case. This is as simple as that.
	 * Fill excel and run the test case. Also where they want they can give the
	 * environment name and run the cases
	 */
	private constants() {
	}

	private static final String GOOGLE_URL = "https://google.com";
	private static final String IRCTC_URL = "https://www.irctc.co.in/nget/train-search";
	private static final String CONFIG_FILE_PATH = "./Resources/config.properties";

	public static String get_GOOGLE_URL() {
		return GOOGLE_URL;
	}

	public static String getIRCTC_URL() {
		return IRCTC_URL;
	}

	public static String getCONFIG_FILE_PATH() {
		return CONFIG_FILE_PATH;
	}
}
