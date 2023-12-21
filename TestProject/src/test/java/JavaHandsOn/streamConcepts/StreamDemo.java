package JavaHandsOn.streamConcepts;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import groovyjarjarantlr4.runtime.tree.Tree;
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

	@Test(description = "convert int array into list")
	public void intArray_toList(){
		int[] nums={3,30,34,5,9};
//		ArrayList<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toCollection(ArrayList::new));
//		int[] ans=Arrays.stream(nums).sorted(Comparator.reverseOrder()).toArray();
//		System.out.println(Arrays.toString(ans));

		List<Integer> ans =IntStream.of(nums).boxed() // boxed is used to convert into Integer stream
				.sorted(Comparator.reverseOrder()).toList().stream().filter(a->a>10).toList();

		System.out.println(ans);
		List<Integer> ans1 =IntStream.of(nums).boxed() // boxed is used to convert into Integer stream
				.sorted(Comparator.reverseOrder()).toList().stream().filter(a->a>10).toList();

		String out="";
		for (int a: ans) out+=a;
		for(int a:ans1) out+=a;
		System.out.println(out);
		ArrayList<Integer> tree = new ArrayList<>();
		for (int a: nums) {
			if(a<10){
				tree.add(a);
			}


		}
		for(int a: nums) if(a>10){
			int[]temp=breakintodigits(a);
			 for(int b:temp) tree.add(b);
		}
//
//		ArrayList<Integer> a =   tree.stream().sorted().collect(Collectors.toList());
		System.out.println(tree+" tree");


	}
	public int[] breakintodigits(int num){

		int len=String.valueOf(num).length();
		int[] nums= new int[len];
		int count=0;
		 while (num>0){
			 nums[count++]=num%10;

			 num=num/10;
		 }
		return nums;
	}

	  @Test(description = "leetcode 179")
	public String leetcode_179(int[] nums){

		  // Convert int array to String array
		  String[] numStrings = new String[nums.length];
		  for (int i = 0; i < nums.length; i++) {
			  numStrings[i] = String.valueOf(nums[i]);
		  }

		  // Sort the String array in a custom order
		  Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));
		  System.out.println(STR."\{Arrays.toString(numStrings)} nums string");
		  // Handle the case where the result is "00" (multiple zeros)
		  if (numStrings[0].equals("0")) {
			  return "0";
		  }

		  // Concatenate the sorted strings to form the largest number
		  StringBuilder result = new StringBuilder();
		  for (String numString : numStrings) {
			  result.append(numString);
		  }

		  return result.toString();
	  }

	  @Test(description = "random idea to call another test from one test !! oh yeah its working omg ")
	public void call(){
		  int[] nums={3,30,34,5,9};
		  System.out.println(leetcode_179(nums));
	  }
	  @Test
	public void samplew(){
		int num=310;

		
	  }
}