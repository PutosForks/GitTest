package collections.collectionsgupta.collections_interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsSet {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Marko");
        emp.setColor("Red");
        emp.setSalary(5.2);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setColor("Blue");
        emp2.setSalary(3.9);

        Employee emp3 = new Employee();
        emp2.setName("Bob");
        emp2.setColor("Blue");
        emp2.setSalary(3.9);


        List<Employee> empList = new ArrayList<>();
        empList.add(emp);
        empList.add(emp2);
        empList.add(emp3);

        System.out.println(empList.size());

        Collection<Employee> empCol = new HashSet<Employee>(empList);
        HashSet<Employee> empSet = (HashSet<Employee>) empCol;

        System.out.println(empSet.size());

        for (Employee e : empSet) {
            System.out.println(e.getName());     // Marko, Bob, null
        }

        // using Stream
        Collection<Employee> empSet2 = empSet.stream().collect(Collectors.toSet());

        for (Employee e : empSet2) {
            System.out.println(e.getName());     // Marko, Bob, null
        }

    }

}
