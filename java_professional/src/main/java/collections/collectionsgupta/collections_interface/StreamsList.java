package collections.collectionsgupta.collections_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;


/*Lambdas on Collection*/
public class StreamsList {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Marko");
        emp.setColor("Red");
        emp.setSalary(5.2);


        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setColor("Blue");
        emp2.setSalary(3.9);

        List<Employee> emps = new ArrayList<>();
        emps.add(emp);
        emps.add(emp2);
        ListIterator empsIter = emps.listIterator();

        while (empsIter.hasNext()) {
            Employee res = (Employee) empsIter.next();
            System.out.println(res.getName());
        }

        emps.forEach(e -> System.out.println(e.getName()));


        emps.stream()
                .filter(e -> e.getColor() == "Blue")
                .forEach(e -> System.out.println("Blue is " + e.getName()));

        String res = emps.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(res);

        Double total = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(total);


    }

}
