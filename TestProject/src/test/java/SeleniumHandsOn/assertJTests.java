package SeleniumHandsOn;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class assertJTests {

	/**
	 * Prerequisite is to add MAVEN dependency of assertJ core into the POM file.
	 * pros are we need not to write so much lines of code in single line of code we
	 * can validate several Things
	 * https://www.youtube.com/watch?v=4FINdRgBjY0&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=11
	 */
	@Test
	public void sampleTestcase() {
		String str = "Hello world";
		String a = "";
		String b = " ";

		Assertions.assertThat(b).isNotNull().isNotEmpty().as("String is actually blank").isNotBlank()
				.isEqualTo("Hello world").overridingErrorMessage(() -> "something went wrong").contains("Hello")
				.doesNotContain("Hi").containsWhitespaces().containsIgnoringCase("world")
				.matches("\\w.*" + " world") /*
												 * here in this pattern we dont care about starting just we are
												 * validating end is world
												 */
				.doesNotContainPattern("\\d.*").hasSize(11).hasSizeGreaterThan(11).hasSizeLessThan(20)
				.hasSizeBetween(10, 20).endsWith("world").isInstanceOf(String.class).hasLineCount(1);

	}
}
