package JavaHandsOn.streamConcepts.StreamExamples;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;
    private String status;


    private int salary;

    public Customer(int id, String name, String email, List<String> phoneNumbers, String status, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name " + name + " , status " + status + ", salary "+salary+" , email " + email + " , phone " + phoneNumbers + "]";

    }
}
