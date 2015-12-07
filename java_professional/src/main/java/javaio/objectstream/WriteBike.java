package javaio.objectstream;


import javaio.file.ResourceDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Bike implements Serializable {
	String model = "Luxury";
	Engine engine = new Engine();
}


class DataMemberNotSerializable {
	public static void main(String args[]) throws Exception {

		File objectFile = new File(ResourceDir.getResourceDir(), "\\object");
		objectFile.mkdir();
		File file = new File(objectFile, "\\bike.data");

		try (
				FileOutputStream out = new FileOutputStream("Bike.data");
				ObjectOutputStream oos = new ObjectOutputStream(out);
		) {
			Bike c = new Bike();
			oos.writeObject(c);  // nope
			oos.flush();
		}
	}
}





