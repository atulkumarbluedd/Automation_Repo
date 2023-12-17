//package JavaHandsOn.streamConcepts;
//
//import java.lang.Runtime.Version;
//import java.util.*;
//import java.util.List;
//import java.util.Map;
//
//import org.assertj.core.util.Arrays;
//import org.testng.annotations.Test;
//
//import JavaHandsOn.streamConcepts.StreamExamples.Customer;
//import JavaHandsOn.streamConcepts.StreamExamples.EkartDataBase;
//
//public class parallelstream {
//	/**
//	 * here we are tring to check the threads used in parallel and normal stream
//	 *
//	 * @param args
//	 */
//	public static void main(String[] args) {
////		IntStream.range(1, 100).forEach(x -> {
////			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
////		});
////		System.out.println("parallel stream threads >>>>>>>>>>>>>>>> ");
////		IntStream.range(1, 100).parallel().forEach(x -> {
////			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
////		});
//		var a = "hello friends";
//		System.out.println(a);
//	}
//
//	@Test(description = "parallel stream example")
//	public void EmployeeStreamTest() throws Exception {
//
//		List<Customer> customers = EkartDataBase.getAll();
//		customers.parallelStream().filter(customer -> customer.getEmail().equals("john@gmail.com")).findAny()
//				.orElseThrow(() -> new Exception("no customer is present with this email id"));
//	}
//
//	@Test
//	public void sampletest() {
//		List<Integer> list = List.of(1, 2, 3, 4, 5, 12);
//		double ans = list.stream().mapToDouble(a -> a).average().getAsDouble();
//		System.out.println(ans);
//		double ansa = list.parallelStream().mapToDouble(a -> a).average().getAsDouble();
//		System.out.println(ansa);
//
//		/* java 10 and it is applicable to only local variables */
//		var a = "hello friends";
//		System.out.println(a);
//		var lists = List.of("sttst", "hhdjsjds");
//		System.out.println(lists);
//		var map = Map.of("1", "GFG", "2", "Geek", "3", "GeeksForGeeks");
//		map.put("hjh", "Sds");
//		/*
//		 * above are immutable map and list means we can not add further elements into
//		 * the list or map we will get unsupported operation exception
//		 */
//		System.out.println(map.get("3"));
//
//		/* get java version */
//		Version r = Runtime.version();
//		System.out.println(r + " java version");
//
//
//
//	}
//	@Test(description = "here when we are addding new element then it will give unsupported operation exception")
//	public void arraysaslist() {
//		int[] ar= {21,2121};
//		List<Integer> lists=Arrays.asList(as);
//
//	}
//}
