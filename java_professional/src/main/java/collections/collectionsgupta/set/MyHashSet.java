package collections.collectionsgupta.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



class Phone{
    String manufacturer;
    Phone(String value) {
        manufacturer = value;
    }
    public String toString() {
        return manufacturer;
    }
}


public class MyHashSet {
    public static void main(String[] args) {
        Set<Phone> set = new TreeSet<>();
        set.add(new Phone("Harry"));                    // compilation error because Phone does not implement Comparator
        set.add(new Phone("Paul"));
        set.add(new Phone("Harry"));
        set.add(new Phone("Paul"));
        Iterator<Phone> iterator = set.iterator();
    }
}