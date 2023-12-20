package JavaHandsOn.streamConcepts.StreamExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {

    public static List<Customer> getAll() {
        return Stream
                .of(new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725"),"inactive",6000),
                        new Customer(101, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"),"inactive",7000),
                        new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"),"inactive",7000),
                        new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"),"active",1000),
                        new Customer(104, "moly", "moly@gmail.com", Arrays.asList("689246829364", "348609467"),"active",3000),
                      new Customer(103, "peter", "peter@gmail.com", Arrays.asList("789246829364", "648609467"),"active",5000))
                .collect(Collectors.toList());
    }

    public static List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725"),"active",5000));
        customerList.add(new Customer(101, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"),"active",6000));
        customerList.add(new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"),"active",8000));
        customerList.add(new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"),"active",90000));
        customerList.add(new Customer(103, "peter", "peter@gmail.com", Arrays.asList("789246829364", "648609467"),"active",1000));
        return customerList;
    }
}

