package Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class random {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");



    }

   void login(String username,String password, WebDriver driver){
       WebElement loginbutton=driver.findElement(By.className("loginclass"));
       WebElement passwordFields=driver.findElement(By.className("passwords"));
       WebElement usernmaeFields=driver.findElement(By.className("username"));

       usernmaeFields.sendKeys(username);
       passwordFields.sendKeys(password);
       loginbutton.click();
       Assert.assertEquals("HomePage",driver.getTitle());

    }
}

