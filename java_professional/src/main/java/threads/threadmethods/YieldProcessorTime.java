package threads.threadmethods;

/**
 * Created by 502413934 on 30.9.2015.
 */
public class YieldProcessorTime {
    public static void main(String args[]) {
        Thread sing = new Sing();
        sing.start();
        Thread.yield();
    }
}
class Sing extends Thread{
    public void run() {
        yield();
        System.out.println("Singing");
    }
}