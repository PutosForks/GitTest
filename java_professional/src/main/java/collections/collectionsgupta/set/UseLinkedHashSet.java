package collections.collectionsgupta.set;

import java.util.*;

class City {
    String name;

    City(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class UseLinkedHashSet {
    public static void main(String args[]) {
        Set<City> route = new LinkedHashSet<>();
        route.add(new City("Seattle"));
        route.add(new City("Copenhagen"));
        route.add(new City("NewDelhi"));

        List<City> extendedRoute = new ArrayList<>();
        extendedRoute.add(new City("Beijing"));
        extendedRoute.add(new City("Tokyo"));

        route.addAll(extendedRoute);

        Iterator<City> iter = route.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
        System.out.println(route.contains(new City("Seattle")));  // false => no implementation of EQUALS
    }
}