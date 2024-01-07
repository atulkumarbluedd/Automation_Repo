package JavaHandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Child extends Parent {
    public void test() {
        System.out.println(" from child class !");

    }

    public static void main(String[] args) {
        /** downcasting**/
        Parent parent=  new Child();
        parent.test();

        /**
         * performing downcasting implicitly
         * child child = new Parent()
         * it will throw compilation error !!
         */
        /** performing downcasting implicitly  **/
        Child child=(Child) parent;
        child.test();

    }

    @Test(description = "upcasting demo")
    public void upcasting_demo(){
        /**
         * upcasting is a type of casting where child class object is casted into parent class object
         * by using upcasting we can access the parent class variables and methods into the child class.
         */
        Parent parent= new Child();
        parent.test();
        parent.test1();
        WebDriver driver= new ChromeDriver();
        driver.get("https://amazon.com");


    }

}
