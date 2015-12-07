package javaio.objectstream;


import javaio.file.ResourceDir;

import java.io.*;

class Engine {
	String name = "Vehicle";
}

class Car extends Engine implements Serializable {
	String model = "Luxury";
}


public class WriteCar {
	public static void main(String[] args) throws Exception {
		File objectFile = new File(ResourceDir.getResourceDir(), "\\object");
		objectFile.mkdir();
		File file = new File(objectFile, "\\car.data");


		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {

			Car o = new Car();
			oos.writeObject(o);
			oos.flush();

			Car o2 = (Car) ois.readObject();
			System.out.println(o2);


		} catch (IOException er) {
			er.printStackTrace();
		}
	}

}
