package kafka.tests;
import kafka.Utils.KafkaConsumerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
public class KafkaSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); // set chromedriver path if needed
        driver.manage().window().maximize();
    }

    @Test
    public void validateKafkaMessageAfterUiAction() {
        // Step 1: Trigger via UI
        driver.get("http://localhost:3000/order");
        driver.findElement(By.id("submit")).click();

        // Step 2: Read Kafka message
        List<String> messages = KafkaConsumerUtils.consumeMessages(10);

        // Step 3: Validate Kafka output
        boolean match = messages.stream().anyMatch(msg -> msg.contains("order placed"));
        Assert.assertTrue(match, "Kafka message for UI action not found.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

}
