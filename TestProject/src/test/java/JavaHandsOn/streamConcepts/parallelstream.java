package JavaHandsOn.streamConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import JavaHandsOn.streamConcepts.StreamExamples.Customer;
import JavaHandsOn.streamConcepts.StreamExamples.EkartDataBase;

public class parallelstream {
	/**
	 * here we are tring to check the threads used in parallel and normal stream
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IntStream.range(1, 100).forEach(x -> {
			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
		});
		System.out.println("parallel stream threads >>>>>>>>>>>>>>>> ");
		IntStream.range(1, 100).parallel().forEach(x -> {
			System.out.println("Thread: " + Thread.currentThread().getName() + " :" + x);
		});
	}

	@Test(description = "parallel stream example")
	public void EmployeeStreamTest() throws Exception {
		
		
		List<Customer> customers = EkartDataBase.getAll();
		customers.parallelStream().filter(customer -> customer.getEmail().equals("john@gmail.com")).findAny()
				.orElseThrow(() -> new Exception("no customer is present with this email id"));
	}
	
	@Test
	public void sampletest() {
		List<Integer> list=List.of(1,2,3,4,5,12);
		double ans=list.stream().mapToDouble(a->a).average().getAsDouble();
		System.out.println(ans);
		double ansa=list.parallelStream().mapToDouble(a->a).average().getAsDouble();
		System.out.println(ansa);
		
	}
}
