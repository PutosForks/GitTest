package collections.collectionsgupta.comparable;


import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person person) {
        return - (this.age - person.age);  // put minus for descedning order
    }

    public String toString() {
        return name;
    }
}

public class TestComparable {
    public static void main(String args[]) {
        TreeSet<Person> set = new TreeSet<>();

        set.add(new Person("Shreya", 12));
        set.add(new Person("Harry", 40));
        set.add(new Person("Paul", 30));
        set.add(new Person("Marko", 30));  // I am not added, for I am equal to paul
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
