package JavaHandsOn.streamConcepts.StreamExamples;

import org.testng.annotations.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class logicalStreamQuestions {
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
        Customer cust = logicalStreamQuestions.getCustomerByEmailID("john@gmail.com");
        System.out.println(cust.getName());

    }

    @Test(description = "print customer details based on id")
    public void customerListBasedOnID() {
        // get all
        List<Customer> customers = EkartDataBase.getAll();
        Map<Integer, List<Customer>> customerListBasedOnID = customers.stream().
                collect(Collectors.groupingBy(Customer::getId, Collectors.toList()));
        customerListBasedOnID.forEach((key, value) -> System.out.println(key + "___" + value));
    }


    @Test(description = "id wise customer count")
    public void customercount_based_onid() {
        List<Customer> customers = EkartDataBase.getAll();
        Map<Integer, Long> customercount_based_onid = customers.stream().collect(Collectors.groupingBy(Customer::getId, Collectors.counting()));
        System.out.println();
        customercount_based_onid.forEach((key, value) -> System.out.println("dept ->> " + key + "  cont ->>" + value));
    }

    @Test(description = "print active and ")
    public void print_active_customers() {
        List<Customer> customers = EkartDataBase.getAll();
        long active_customers_count = customers.stream().filter(customer -> customer.getStatus().equalsIgnoreCase("active")).count();
        System.out.println(STR."active employee count \{active_customers_count}");
    }

    @Test(description = "print max and min salary from customer")
    public void max_min_salaryForcustomer() {
        List<Customer> customers = EkartDataBase.getAll();
        Optional<Customer> minSalary = customers.stream().min(Comparator.
                comparing(Customer::getSalary));
        System.out.println(STR."minSalary is \{minSalary}");
        Optional<Customer> maxSalary = customers.stream().max(Comparator.
                comparing(Customer::getSalary));
        System.out.println(STR."maxSalary is \{maxSalary}");

        // if we want to get the exact salary what it is then use like below
        List<Customer> ans = maxSalary.stream().toList();
        System.out.println(ans.getFirst().getSalary());

    }

    @Test(description = "id wise max and min salary")
    public void print_id_wise_max_min_sal() {
        List<Customer> customers = EkartDataBase.getAll();
        Map<Integer, Optional<Customer>> idWiseMaxSalary = customers.stream().
                collect(Collectors.groupingBy(Customer::getId, Collectors.
                        reducing(BinaryOperator.maxBy(Comparator.comparing(Customer::getSalary)))));
        idWiseMaxSalary.entrySet().forEach(System.out::println);
        System.out.println("min salary by id");

        Map<Integer, Optional<Customer>> idWiseMinSalary = customers.stream().
                collect(Collectors.groupingBy(Customer::getId, Collectors.
                        reducing(BinaryOperator.minBy(Comparator.comparing(Customer::getSalary)))));
        idWiseMinSalary.entrySet().forEach(System.out::println);

    }


}
