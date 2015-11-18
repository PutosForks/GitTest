package collections.collectionsgupta.algorithms.array;


import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person person) {
        return -(this.age - person.age);  // put minus for descedning order
    }

    public String toString() {
        return name;
    }
}


public class SortObjects2 {

    public static void main(String[] args) {


        Person p1 = new Person("Shreya", 32);
        Person p2 = new Person("Harry", 40);
        Person p3 = new Person("Paul", 30);

        Person[] objArray = new Person[]{p1, p2, p3};

        Arrays.sort(objArray,
                new Comparator<Person>() {
                    public int compare(Person p1, Person p2) {
                        return (p1.age - p2.age);
                    }
                }
        );

        for (Person p:objArray) System.out.print(p + " ");


    }
}
