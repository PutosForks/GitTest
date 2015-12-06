package collections.collectionsgupta.collections_interface;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        Department department = new Department("IT");

        Employee emp = new Employee();
        emp.setName("Marko");
        emp.setColor("Red");
        emp.setSalary(5.2);
        emp.setDepartment(department);


        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setColor("Blue");
        emp2.setSalary(3.9);
        emp2.setDepartment(department);

        Employee emp3 = new Employee();
        emp3.setName("Dominik");
        emp3.setColor("Black");
        emp3.setSalary(3.9);
        emp3.setDepartment(new Department("HR"));

        List<Employee> e = new ArrayList();
        e.add(emp);
        e.add(emp2);
        e.add(emp3);


        Map<Department, List<Employee>> byDept = e.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(byDept.containsKey(new Department("IT")));

        ListIterator<Employee> emps = byDept.get(new Department("IT")).listIterator();

        while (emps.hasNext()) {
            System.out.println(emps.next().getName());
        }

        Map<Department, Double> totalByDep = e.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)));


        for (Map.Entry<Department, Double> entry : totalByDep.entrySet()) {
            System.out.println("Department: " + entry.getKey().getName() + " total is: " + entry.getValue());

        }

       // e.stream().max(Comparator.<Employee>naturalOrder()).ifPresent(Employee::getSalary);

    }

}
