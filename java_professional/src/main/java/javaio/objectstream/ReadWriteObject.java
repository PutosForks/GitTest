package javaio.objectstream;


import javaio.file.ResourceDir;

import java.io.*;

class Machine implements Serializable {

}

public class ReadWriteObject {
	public static void main(String[] args) throws Exception {
		File objectFile = new File(ResourceDir.getResourceDir(), "\\object");
		objectFile.mkdir();
		File file = new File(objectFile, "\\machine");


		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {

			Machine o = new Machine();
			oos.writeObject(o);
			oos.flush();

			Machine o2 = (Machine) ois.readObject();
			System.out.println(o2);


		} catch (IOException er) {
			er.printStackTrace();
		}


	}


}
