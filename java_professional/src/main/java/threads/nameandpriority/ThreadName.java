
package threads.nameandpriority;


public class ThreadName {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        System.out.println(t1); //Thread[Thread-0,5,main]
        System.out.println(t2); //Thread[Thread-1,5,main]
        
        t2.setPriority(10);// higest priority
        t2.setName("Ed");
        System.out.println(t2);  //Thread[Ed,10,main]
        
        class Inner {
            public Thread t3 = new Thread();
        }
        
        Inner ti =  new Inner();
        
        System.out.println(ti.t3); // Thread[Thread-2,5,main]
        
        
        
        
        
        
    }
    
}
