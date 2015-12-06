package collections.collectionsgupta.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeSample {
    public static void main(String[] args) {


        Deque<String> aDeque = new ArrayDeque<>();

        aDeque.addFirst("tea");
        aDeque.addFirst("milk");
        aDeque.addFirst("coffee");
        aDeque.addLast("sugar");

        // iterate and print
        Iterator it = aDeque.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        aDeque.addFirst("Juice");
        aDeque.addLast("Sugar");

        System.out.println(aDeque.getFirst());
        System.out.println(aDeque.getLast());

              /* Removal of the Deque Elements */
        System.out.println("First Element(Removed):"+aDeque.removeFirst());
        System.out.println("Last Element Removed:"+aDeque.removeLast());

        System.out.println("%nPopped Element : " + aDeque.pop());
        System.out.println("%n Size of Array Deque: " + aDeque.size());

        ;


    }
}
