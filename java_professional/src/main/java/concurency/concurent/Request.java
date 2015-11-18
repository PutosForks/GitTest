package concurency.concurent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Request {
}


class Client implements Runnable {

	private BlockingQueue<Request> queue;
	Client (BlockingQueue<Request> queue) {
		this.queue = queue;
	}

	public void run() {
		Request request = null;
		try {
			while (true) {
				request = new Request();
				queue.put(request);  // waits if necessary for space
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}

}

class Server implements Runnable {

	private BlockingQueue<Request> queue;
	Server(BlockingQueue<Request> queue) {
		this.queue = queue;
	}

	public void run () {
		try {
			while (true) {
				System.out.println("processing .. " + queue.take() + Thread.currentThread().getName());// waits if necessary for items to apear
			}

		} catch (InterruptedException ex) {
			System.out.println(ex);
		}

	}

}

	class LoadTesting {
		public static void main(String[] args) {
			BlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(3);

			Client client = new Client (queue);
			Server server = new Server (queue);
			new Thread(client).start();
			new Thread(server).start();

		}
	}

