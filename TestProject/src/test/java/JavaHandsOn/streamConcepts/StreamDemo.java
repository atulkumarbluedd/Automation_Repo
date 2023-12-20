package JavaHandsOn.streamConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class StreamDemo {
	/**
	 * This class is to just demonstrate various methods and ways to use stream
	 * @param args
	 */
	public static void main(String[] args) {
//	
		long start=0;
		long end=0;
		start = System.currentTimeMillis();
		IntStream.range(1, 1890).forEach(System.out::print);
		end = System.currentTimeMillis();
		System.out.println();
       System.out.println(" plain stream took time of execution " + (end-start)+"__");
       
       long start1 = System.currentTimeMillis();
       
       IntStream.range(1,1890).parallel().forEach(System.out::print);
      long end1 = System.currentTimeMillis();
       System.out.println();
       System.out.println(" parallel stream took time of execution " + (end1-start1)+"__");

	}

	@Test(description = "for odd values double the number in a sorted order")
	public void testcase1() {
		List<Integer> nums = Arrays.asList(9, 3, 2, 4, 19);
		nums.stream().sorted().filter(a -> a % 2 != 0).map(a -> a * 2).forEach(a -> System.out.print(a + " "));
	}

	@Test(description = "use predicate functional interface as map takes predicate functional interface arg. and overide the test method and provide your logic")
	public void testcase2() {
		Predicate<Integer> predi = new Predicate<Integer>() {
			@Override
			public boolean test(Integer input) {
				// TODO Auto-generated method stub
				return input % 2 == 0;
			}

			@Override
			public boolean apply(Integer input) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		List<Integer> nums = Arrays.asList(9, 3, 2, 4, 19);
		nums.stream().sorted().filter(predi).forEach(a -> System.out.print(a + " "));

	}

	@Test(description = "reduce method demo")
	public void reduce_demo() {
		List<Integer> nums = Arrays.asList(9, 3);
		int sum = nums.stream().reduce(0, (c, e) -> c + e);
		System.out.println(sum);
	}

	@Test()
	public void intstreamDemo() {
	
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		Stream<Integer> data = nums.stream();
		data.forEach(a -> System.out.println(a));
		/***
		 * 1. once stream is used can not be reused >>>> 2. actual list is untouched.
		 * 
		 */
		data.forEach(a -> System.out.println(a)); // this will not work as stream is already used
	}

	@Test(description = "This method is to format string in a way that we wanted usig joining method")
	public void formatStreamOutput(){
		List<String> nums = Arrays.asList("ron", "sam", "josh", "jerry");
		String listToString = nums.stream()
				.collect(Collectors.joining(", ", "[", "]"));
		System.out.println(listToString);
	}

}