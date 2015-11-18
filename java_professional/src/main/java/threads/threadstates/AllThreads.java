package threads.threadstates;

import java.util.Set;

/**
 * Created by 502413934 on 30.9.2015.
 */
public class AllThreads {
    public static void main(String[] args) {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for(Thread t : threadSet)
            System.out.println(t + " --- " + t.getState());
    }
}
