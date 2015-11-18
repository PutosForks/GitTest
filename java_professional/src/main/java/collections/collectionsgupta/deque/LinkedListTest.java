package collections.collectionsgupta.deque;

import java.util.*;

class LinkedListTest {

    public static void main(String[] args) {
        String palStr = "abcba";
        System.out.println("Input string is: " + palStr);
        List<Character> palindrome = new LinkedList<Character>();

        for (char ch : palStr.toCharArray()) {
            palindrome.add(ch);
        }

        ListIterator<Character> iterator = palindrome.listIterator();
        ListIterator<Character> revIterator = palindrome.listIterator(palindrome.size());

        boolean result = true;
        while (revIterator.hasPrevious() && iterator.hasNext()) {
            if (iterator.next() != revIterator.previous() ) {
                result = false;
                break;
            }
        }
        if (result) {
            System.out.print("Input string is a palindrome");
        } else {
            System.out.print("Input string is not a palindrome");
        }
    }
}
