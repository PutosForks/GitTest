package javaio.ByteStreams.datastream;

import javaio.file.ResourceDir;

import java.io.*;

public class ReadWritePrimitiveData {
	public static void main(String... args) throws IOException {

		File dataDir = new File(ResourceDir.getResourceDir(), "data");
		dataDir.mkdir();
		File dataFile = new File(dataDir, "myData.data");
		dataFile.createNewFile();

		try (
				FileOutputStream fos = new FileOutputStream(dataFile);
				DataOutputStream dos = new DataOutputStream(fos);
				FileInputStream fis = new FileInputStream(dataFile);
				DataInputStream dis = new DataInputStream(fis);
		) {
			dos.writeChars("OS");
			dos.writeInt(999);
			dos.writeDouble(45.8);
			dos.writeBoolean(true);
			dos.writeUTF("Will score 100%");
			System.out.println(dis.readChar());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
//System.out.println(dis.readBoolean());
		}
	}
}
