package concurency.lock.atomic;

import java.util.concurrent.atomic.AtomicInteger;


public class Book {
		String title;
		AtomicInteger copiesSold = new AtomicInteger(0);

		Book(String title) {
			this.title = title;
		}
		public void newSale() {
			copiesSold.incrementAndGet();
		}
		public void returnBook() {
			copiesSold.decrementAndGet();
		}

		public Integer incrementAndPrint() {
			return copiesSold.incrementAndGet();
	}

}
