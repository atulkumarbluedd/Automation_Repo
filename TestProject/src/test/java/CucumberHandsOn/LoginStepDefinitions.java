package CucumberHandsOn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {

    private WebDriver driver;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // Initialize WebDriver (Assuming you have set up Selenium and ChromeDriver)
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("clicks the login button")
    public void clicksTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        WebElement welcomeMessage = driver.findElement(By.id("welcome-message"));
        assertTrue(welcomeMessage.isDisplayed());

        // Close the browser
        driver.quit();
    }
}
