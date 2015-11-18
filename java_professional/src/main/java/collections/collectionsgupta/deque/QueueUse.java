package collections.collectionsgupta.deque;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUse {

    public static void main(String[] args) {
        Queue<String> loginSeq = new LinkedList<>();

        loginSeq.add("Lennon");
        loginSeq.add("McCartney");
        loginSeq.add("Starr");
        loginSeq.add("Harrison");

        System.out.println(loginSeq);

        loginSeq.remove();  // removes Lennon FIFO

        System.out.println(loginSeq);

    }
}
