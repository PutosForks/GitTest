package collections.collectionsgupta.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeUse {

    public static void main(String[] args) {
        Deque<String> sp = new ArrayDeque<>();

        sp.add("One");
        sp.add("Two");   
        sp.add("Three");
        sp.addFirst("Zero");
        sp.addLast("Three");

        System.out.println(sp);

        sp.removeFirst();
        sp.removeLast();

        System.out.println(sp);

    }

}
