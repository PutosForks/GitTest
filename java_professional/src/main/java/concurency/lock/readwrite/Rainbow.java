package concurency.lock.readwrite;

import java.util.*;
import java.util.concurrent.locks.*;
class Rainbow {
	private final ReadWriteLock myLock = new ReentrantReadWriteLock();
	private static int pos;
	static Map<Integer, String> colors = new HashMap<>();
	public void addColor(String newColor) {
		myLock.writeLock().lock();
		try {
			colors.put(new Integer(++pos), newColor);
		}
		finally {
			myLock.writeLock().unlock();
		}
	}

	public void display() {
		myLock.readLock().lock();
		try {
			for (String s : colors.values()) {
				System.out.println(s);
			}
		}
		finally {
			myLock.readLock().unlock();
		}
	}
}