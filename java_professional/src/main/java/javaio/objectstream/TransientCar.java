package javaio.objectstream;


import javaio.file.ResourceDir;

import java.io.*;

public class TransientCar implements Serializable {
	String name;
	transient String model;
	transient int days;
	static int carCount;
	TransientCar(String value) {
		name = value;
		model = "some value";
		days = 98;
		++carCount;
	}
}



class ReadWriteCarObjects{
	public static void main(String args[]) throws Exception {
		File objectFile = new File(ResourceDir.getResourceDir(), "\\object");
		objectFile.mkdir();
		File file = new File(objectFile, "\\transientcar.data");

		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			TransientCar c = new TransientCar("AAA");
			oos.writeObject(c);
			oos.flush();
			new TransientCar("BBB");
			TransientCar c2 = (TransientCar)ois.readObject();
			System.out.println(c2.name);
			System.out.println(c2.model + ":" + c2.days);
			System.out.println(c2.carCount);
		}
	}
}
