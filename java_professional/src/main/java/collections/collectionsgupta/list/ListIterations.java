package collections.collectionsgupta.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;


public class ListIterations {


    static <T> List<? extends T> getPlanetsReverse(List<? extends T> list) {

        List<T> reverse = new ArrayList<>();
        T el;
        for (ListIterator<? extends T> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            el = (T) it.previous();
            System.out.println(el);
            reverse.add(el);
        }
        return reverse;

    }

    static <T> void replacePlanetswithIterator(List<T> list, T oldVal, T newVal) {
        ListIterator<T> it;
        for (it = list.listIterator(); it.hasNext(); ) {
            // pokud je hodnota oldVal = NULL, tak se preskoci
            if (oldVal == null ? it.next() == null : oldVal.equals(it.next())) {
                it.set(newVal);
            }
        }
    }


    static <T> void injectVals(List<? extends T> list, T val, List<? extends T> arr) {
        for (ListIterator it = list.listIterator(); it.hasNext(); ) {
            if (val.equals(it.next())) {
                it.add(arr);
            }
        }
    }


    static <T> List<T> dealHand(List<T> deck, int n) {
        int deckSize = deck.size();
        List<T> hand = deck.subList(deckSize - n, deckSize);
        return hand;
    }


    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uran", "Neptun"};
        List<String> planetList = new ArrayList<>();
        planetList.addAll(Arrays.asList(planets));


        ListIterations li = new ListIterations();

        List<? extends String> res = ListIterations.<String>getPlanetsReverse(planetList);
        System.out.println(res);

        List<String> planetList2 = planetList;

        replacePlanetswithIterator(planetList2, "Earth", "Bravos");
        System.out.println(planetList2);

        List<String> planetList3 = planetList;
        String[] asteroids = {"Ceres", "Vesta", "Pallas", "Iris"};
        List<String> asteroidList = new ArrayList<>();
        asteroidList.addAll(Arrays.asList(asteroids));

        injectVals(planetList3, "Mars", asteroidList);
        System.out.println(planetList3);


        List<Integer> deck = new ArrayList<>();
        deck.add(1);
        deck.add(2);
        deck.add(3);
        deck.add(4);
        deck.add(5);
        deck.add(6);
        deck.add(7);
        deck.add(8);

        System.out.println(dealHand(deck, 2));
    }


}