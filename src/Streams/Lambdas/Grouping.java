package Streams.Lambdas;

import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class Grouping {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Sanjai", "IT", 60000),
                new Employee("Rahul", "HR", 45000),
                new Employee("Kiran", "IT", 70000),
                new Employee("Arun", "Finance", 50000),
                new Employee("Meena", "HR", 48000)
        );

        Map<String, List<Employee>> grouped =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        grouped.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList);
        });
    }
}
