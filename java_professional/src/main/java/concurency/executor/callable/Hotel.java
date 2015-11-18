package concurency.executor.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Order implements Callable<Void>{
	String name;
	Order(String name) {this.name = name;}
	public Void call() throws Exception {
		System.out.println(name);
		if (name.equalsIgnoreCase("berry"))
			throw new Exception("Berry unavailable");
		return null;
	}
}


class Hotel {
	ExecutorService service = Executors.newFixedThreadPool(5);
	public void orderFood(Order order) {
		service.submit(order);  // Submit Callable to ExecutorService for execution.
	}
	public void hotelClosedForDay() {
		service.shutdown();   // Disable new tasks from being submitted.
	}
	public void hotelClosedForever() {
		service.shutdown();
		try {
			if (!service.awaitTermination(60, TimeUnit.SECONDS)) { // wait 60 seconds for running tasks to finish
				service.shutdownNow();
				if (!service.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			service.shutdownNow();               // recancel if all above fails
			Thread.currentThread().interrupt();  // kill current, preserve interupt status
		}
	}
}