package collections.collectionsgupta.deque;

import java.util.ArrayDeque;
import java.util.Arrays;


public class TestArrayDeque {
    public static void main(String... args) {
        String strArray[] = {"A1", "B2", "C3"};
        ArrayDeque<String> arrDeque = new
                ArrayDeque<String>(Arrays.asList(strArray));
        arrDeque.push("D4");   // adds to beginning
        arrDeque.offer("E5");   //  adds to end
        //arrDeque.push(null);   // Runtime NullPointerexception
        System.out.println(arrDeque.pop());  // gets the first at beginning
        System.out.println(arrDeque.remove());    // removes from beginning
        arrDeque.add("F6");                             // adds to end
        System.out.println(arrDeque.peek());           // looks at the beginning
        System.out.println(arrDeque);

        System.out.println(arrDeque);
    }
}
