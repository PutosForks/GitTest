package concurency.lock.interruptible;

import java.util.concurrent.locks.*;

class Bus {
	Lock lock = new ReentrantLock();

	public void boardBus(String name) {
		System.out.println(name + " : boarded");
	}
}

class Employee extends Thread {
	Bus bus;
	String name;

	Employee(String name, Bus bus) {
		this.name = name;
		this.bus = bus;
	}

	public void run() {
		try {
			bus.lock.lockInterruptibly();
			try {
				bus.boardBus(name);
			} finally {
				bus.lock.unlock();
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}


}

public class TestLock {
	public static void main(String[] args) {

		Bus bus = new Bus();
		Employee paul = new Employee("Paul", bus);
		Employee shreya = new Employee("Shreya", bus);

		paul.start();
		shreya.start();
		paul.interrupt();
	}


}
