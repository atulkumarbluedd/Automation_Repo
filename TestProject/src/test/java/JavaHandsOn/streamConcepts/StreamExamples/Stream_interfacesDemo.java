package JavaHandsOn.streamConcepts.StreamExamples;

import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_interfacesDemo {
    /**
     * predicate functional interface has one abstract test method
     * basically there are 4 functional interfaces mainly introduced
     * 1. predicate -> test method
     * 2. supplier -> get method
     * 3. consumer -> modifies data return no output -> apply method
     * 4. Function -> apply method
     */

    @Test(description = "check the usage of predicate functional interface")
    public void checkPredicate() {
        /*check if the string length is greater than 5 return true else false*/
        Predicate<String> checkLength = str -> str.length() > 5;
        System.out.println(checkLength.test("hel"));
    }

    @Test(description = "check the usage of consumer functional interface")
    public void checkConsumer() {
        /**
         * consumer only modifies the data with no return value
         */
        Person p = new Person();
        Consumer<Person> setName = t -> t.setName("Rohan");
        setName.accept(p);
        System.out.println(p.getName());
    }

    @Test(description = "check Function interface of functional interface !! it has method as apply")
    public void checkFunction() {
        // here first arg is input and second arg is output
        Function<Integer, String> getInt = t -> t * 10 + " data multiplied by 10";
        System.out.println(getInt.apply(2));
    }

    @Test(description = "check supplier, it takes no i/p and only provide only o/p !! it has only get method")
    public void checkSupplier() {
        Supplier<Double> getRandomDouble = () -> Math.random();
        System.out.println(getRandomDouble.get()); // no i/p

    }

    /**
     * ** terminal operations -- stream api
     * 1. toArray()
     * 2. collect()
     * 3. count()
     * 4. reduce()
     * 5.foreach()
     * 6.forEachordered()
     * 7.min()
     * 8.max()
     * 9.anyMatch()
     * 10.allMatch()
     * 11.noneMatch()
     * 12.findAny()
     * 13.findFirst()
     */
    @Test(description = "Terminal operations demo")
    public void terminalOperationsDemo() {
        // 1. toArray()
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 12);
        Object[] ans = list.stream().toArray();
        System.out.println(ans[2]);
        //2. collect()
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        set.stream().forEach(System.out::println);
        //3. count
        System.out.println("count is " + set.stream().count());

        //4. forEachOrdered
        set.stream().forEachOrdered(System.out::print);

        //5. min and max
        System.out.println("min is " + set.stream().min((a, b) -> a - b).get());
        System.out.println("max is " + set.stream().max((a, b) -> a - b).get());
        // if we reverse a-b to b-a then min function will give max value and max will give min value

        //6. anyMatch(), noneMatch() and allMatch()
        // if any element is matching from list of elements then it will give true else false
        // allMatch is to check if all the elements are matching then return true else false
        // if none of the element match the criteria then return true

        System.out.println("any match  " + list.stream().anyMatch(e -> e == 5));
        System.out.println(STR."all match \{list.stream().allMatch(e -> e / 1 == e)}");
        System.out.println(STR."none match \{list.stream().noneMatch(e -> e == 5)}");


    }

    /**
     * stream --- Intermediate operations
     * 1.filter
     * 2.map
     * 3.flatmap
     * 4.distinct
     * 5.sorted
     * 6.peek
     * 7.limit
     * 8.skip
     */
    @Test(description = "Demo for intermediate operations !!")
    public void intermediateOperations() {
        List<String> list = Arrays.asList("aabc", "dfg", "hjhjk", "aabc");
        list.stream().flatMap(a -> Stream.of(a.charAt(1))).forEach(System.out::print);
        //distinct
        System.out.println(" distinct function");
        list.stream().distinct().forEach(System.out::println);


        List<Integer> nums = Arrays.asList(11, 2, 5, 4, 12);
        System.out.println("sorted " + nums.stream().sorted().toList());

        // limit function >> here we have given 3 then only 3 elements will come

        // skip >> skip 3 elements
        System.out.println("skip " + nums.stream().skip(3).toList());

    }
}


class Person {

    @Getter
    @Setter
    private String name;

}
