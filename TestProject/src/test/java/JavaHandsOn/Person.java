package JavaHandsOn;

import org.testng.annotations.DataProvider;

public class Person {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

   public Person(String name, String age) {
        this.age = age;
        this.name = name;
    }

    /**
     * Here we have to make it static otherwise it will not work from diff class.
     * below exception we will recieve
     * org.testng.TestNGException:
     * Couldn't find a constructor in class JavaHandsOn.Person
     */
    @DataProvider
    public static Person[] personDetails() {
        return new Person[]{
                new Person("Atul", "35"),
                new Person("shyam", "43"),
                new Person("vaishali", "32")
        };
    }
}
