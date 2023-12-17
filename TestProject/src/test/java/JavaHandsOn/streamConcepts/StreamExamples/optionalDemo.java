package JavaHandsOn.streamConcepts.StreamExamples;

import java.util.List;
import java.util.stream.Collectors;

public class optionalDemo {
	public static Customer getCustomerByEmailID(String email) throws Exception {
		List<Customer> customers = EkartDataBase.getAll();
		return customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
				.orElseThrow(() -> new Exception("no customer is present with this email id"));
	}

	public static void main(String[] args) throws Exception {
		List<Customer> customers = EkartDataBase.getAll();
		customers.stream().map(cust -> cust.getEmail()).collect(Collectors.toList()).forEach(a -> System.out.print(a));
		System.out.println();
		/* flat map vs normal map here we have one to many mapping for phone number */
		customers.stream().map(cust -> cust.getPhoneNumbers()).collect(Collectors.toList())
				.forEach(a -> System.out.print(a));
		System.out.println();
		customers.stream().flatMap(cust -> cust.getPhoneNumbers().stream()).forEach(a -> System.out.print(a + " "));
		System.out.println();
		Customer cust = optionalDemo.getCustomerByEmailID("john@gmail.com");
		System.out.println(cust.getName());

	}

}
