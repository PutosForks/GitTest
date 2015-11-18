package concurency.executor.executor;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class Order implements Runnable {
	String name;
	Order(String name) {this.name = name;}
	public void run() {
		System.out.println(name);
	}
}

	class Hotel implements Executor {
		final Queue<Runnable> custQueue = new ArrayDeque<>();
		public void execute(Runnable r) {
			synchronized(custQueue) {
				custQueue.offer(r); // puts a task into a queue
			}
			processEarliestOrder();
		}
		private void processEarliestOrder() {
			synchronized(custQueue) {
				Runnable task = custQueue.poll(); // gets a task from the queue
				new Thread(task).start();         // executes task
			}
		}
	}

	class runOrders {
		public static void main(String[] args) {
			Hotel h1 =  new Hotel();
			h1.execute(new Order("Tea"));
			h1.execute(new Order("Coffee"));
			h1.execute(new Order("Juice"));
			h1.execute(new Order("Milk"));
		}

	}
