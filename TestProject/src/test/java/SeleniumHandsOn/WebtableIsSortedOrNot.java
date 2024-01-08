package SeleniumHandsOn;

import SeleniumHandsOn.Factories.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebtableIsSortedOrNot {

    @Test(description = "This test is to demonstrate about handling web tables !!")
    public void checkSorted_or_not_List() {
        WebDriver driver = Drivermanager.getDriver();

        WebElement table = driver.findElement(By.id("tableId"));
        List<WebElement> nameColumnElements = table.findElements(By.xpath("//td[@class='name-column']"));
        List<String> originalNames = new ArrayList<>();

        for (WebElement element : nameColumnElements) {
            originalNames.add(element.getText());
        }

        List<String> sortedNames = new ArrayList<>(originalNames);
        Collections.sort(sortedNames);
        boolean isSorted = originalNames.equals(sortedNames);
        if (isSorted) {
            System.out.println("The 'Name' column is sorted in ascending order.");
        } else {
            System.out.println("The 'Name' column is not sorted correctly.");
        }
        driver.quit();
    }

    @Test(description = "!! List comparison !!")
    public void checkListComparison() {
        ArrayList<String> list = new ArrayList<>();
        list.add("sohan");
        list.add("rohan");
        list.add("hjk");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("sohan");
        list1.add("hjk");
        list1.add("rohan");

        System.out.println(list1.equals(list)); // false as order was changed !!

    }
}
