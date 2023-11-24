package SeleniumHandsOn;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class checkIsFiledownloadedOrNot {
	@Test(description = "when we have heavy file we want to check after few minutes whether"
			+ "file is downloaded or not !!")
	public void fileIsdownloadedOrNot() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jenkins.io/download/thank-you-downloading-windows-installer-stable");
		String downloadPath = "C:\\Users\\91977\\Downloads";

		File file = new File(downloadPath, "jenkins.msi");

		FluentWait<File> wait = new FluentWait<File>(file).pollingEvery(Duration.ofSeconds(5000))
				.withTimeout(Duration.ofMinutes(5)).ignoring(Exception.class).withMessage("File is not downloaded !!");

		boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());

		System.out.println(isDownloaded);
		if(isDownloaded) {
			System.out.println("file is downloaded !!");
		}
		else {
			System.out.println("file is not completly downlaoded !!");
		}
	}
}
