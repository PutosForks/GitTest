package collections.collectionsgupta.comparable;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Person2 implements Comparable<Person2> {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person2 person) {
        return name.compareTo(person.name); // ordering by name (Strings)
    }

    public String toString() {
        return name;
    }
}

public class TestComparable2 {


    public static void main(String[] args) {
        TreeSet<Person2> set = new TreeSet<>();

        set.add(new Person2("Shreya", 12));
        set.add(new Person2("Harry", 40));
        set.add(new Person2("Paul", 30));
        set.add(new Person2("Marko", 30));
        Iterator<Person2> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        TreeSet<Person2> ageSet = new TreeSet<>(new Comparator<Person2>() {
            public int compare(Person2 o1, Person2 o2) {
                return o1.age - o2.age;
            }
        });


        ageSet.add(new Person2("Shreya", 12));
        ageSet.add(new Person2("Harry", 40));
        ageSet.add(new Person2("Paul", 30));
        ageSet.add(new Person2("Marko", 34));


    Iterator<Person2> ageIterator = ageSet.iterator();
    while(ageIterator.hasNext())

    {
        System.out.println(ageIterator.next());
    }


}

}
