package JavaHandsOn.streamConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObjectCreation_stream {
    public static void main(String[] args) {
        advanceSwitch(2);
        var j = 10;
        System.out.println(j);
        // 1st way blank stream
        Stream<Object> emptyStream = Stream.empty();
        String[] names = {"Durgesh", "Uttam", "Ankit", "Divya"};
        // 2nd way using of method
        Stream<String> stream1 = Stream.of(names);
        stream1.forEach(System.out::println);
        // 3rd way using builder pattern
        Stream<Object> streamBuilder = Stream.builder().build();
        // 4th way
        IntStream numsStream = Arrays.stream(new int[]{1, 2, 3, 4, 12});
        Stream<String> stream2 = Arrays.stream(new String[]{"ghg", "hhehhj"});
        List<Integer> numbers = List.of(1, 21, 32, 222);
        /* Find min number*/
        Integer ans = numbers.stream().min((x, y) -> x.compareTo(y)).get();
        Integer min_number = numbers.stream().min(Integer::compareTo).get();
        System.out.println(min_number);
        // find first number
        Integer firstelement = numbers.stream().findFirst().get();
        System.out.println(firstelement);
//        int sum = numbers.stream().reduce(0, (a, e) -> a + e);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        int max = numbers.stream().reduce(0, Integer::max);
        System.out.println(max);
        // convert into upper case of letters
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String uppercase = letters.stream().reduce("", (a, b) -> a.toUpperCase() + b.toUpperCase());
        System.out.println(uppercase);
    }


    public static void advanceSwitch(int n) {
        switch (n) {

            case 2 -> System.out.println("It's a laptop!");
            case 3 -> System.out.println("It's a desktop!");
            case 4, 5 -> System.out.println("It's a mobile phone!");
            default -> throw new IllegalStateException(STR."Unexpected value: \{n}");
        }
        ;
    }
}
