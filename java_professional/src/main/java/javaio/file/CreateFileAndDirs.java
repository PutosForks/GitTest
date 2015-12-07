package javaio.file;

import java.io.File;
import java.io.IOException;


public class CreateFileAndDirs {
	public static void main(String[] args) {

		File dir = ResourceDir.getResourceDir();

		File newDirs = new File (dir, "top\\middle\\bottom");
		newDirs.mkdirs();
		File newTextFile = new File(newDirs, "Hello.txt");

		if (!newTextFile.exists()) {
			try {
				newTextFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
				}
		}


	}
}
