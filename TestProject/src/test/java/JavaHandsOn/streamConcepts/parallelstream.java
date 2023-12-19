package JavaHandsOn.streamConcepts;

import JavaHandsOn.streamConcepts.StreamExamples.Customer;
import JavaHandsOn.streamConcepts.StreamExamples.EkartDataBase;
import org.testng.annotations.Test;

import java.lang.Runtime.Version;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class parallelstream {
    /**
     * here we are tring to check the threads used in parallel and normal stream
     *
     * @param args
     */
    public static void main(String[] args) {
//		IntStream.range(1, 100).forEach(x -> {
//			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
//		});
//		System.out.println("parallel stream threads >>>>>>>>>>>>>>>> ");
//		IntStream.range(1, 100).parallel().forEach(x -> {
//			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
//		});
        var a = "hello friends";
        System.out.println(a);
    }

    @Test(description = "parallel stream example")
    public void EmployeeStreamTest() throws Exception {

        List<Customer> customers = EkartDataBase.getAll();
        customers.parallelStream().filter(customer -> customer.getEmail().equals("john@gmail.com")).findAny()
                .orElseThrow(() -> new Exception("no customer is present with this email id"));
    }

    @Test
    public void sampletest() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 12);
        double ans = list.stream().mapToDouble(a -> a).average().getAsDouble();
        System.out.println(ans);
        double ansa = list.parallelStream().mapToDouble(a -> a).average().getAsDouble();
        System.out.println(ansa);

        /* java 10 and it is applicable to only local variables */
        var a = "hello friends";
        System.out.println(a);
        var lists = List.of("sttst", "hhdjsjds");
        System.out.println(lists);
        var map = Map.of("1", "GFG", "2", "Geek", "3", "GeeksForGeeks");
        map.put("hjh", "Sds");
        /*
         * above are immutable map and list means we can not add further elements into
         * the list or map we will get unsupported operation exception
         */
        System.out.println(map.get("3"));

        /* get java version */
        Version r = Runtime.version();
        System.out.println(r + " java version");


    }

    @Test(description = "stream. itreate method to print elements from 40, with increament of 2 and max we want 5 elements ")
    public void randomMethods_Stream() {
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(5);
        streamIterated.forEach(System.out::println);


        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(2);
        onceModifiedStream.forEach(System.out::println);
        /* twice modified stream*/

        Stream<String> twiceModifiedStream =
                Stream.of("abcdewew", "bbcdewewew", "cbcdewewewe").skip(1).map(element -> element.substring(0, 4));
        twiceModifiedStream.forEach(System.out::println);

        long count = Stream.of("abcdewew", "bbcdewewew", "cbcdewewewe").skip(1).map(element -> element.substring(0, 4)).count();

        var list = List.of("sttst3", "hhdjsjds");
        Optional<String> stream = list.stream().filter(element -> element.contains("3"))
                .map(String::toUpperCase).findFirst();
        System.out.println(stream.get());
        /**
         * 10+1
         * 10+2
         * 10+3
         * total = 36
         */
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> a + b);
        System.out.println(reducedParallel);
//
    }
}
