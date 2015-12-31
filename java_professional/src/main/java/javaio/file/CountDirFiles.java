package javaio.file;

import java.io.File;


public class CountDirFiles {
	public static void main(String[] args) {
		int directoryCount = 0;
		int fileCount = 0;
		File dir = ResourceDir.getResourceDir();
		System.out.println(dir.isDirectory());
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File fileItem: files) {
				if (fileItem.isDirectory())   directoryCount++;
				if (fileItem.isFile()) fileCount++;


			}
			System.out.println("Directory count " + directoryCount);
			System.out.println("File count " + fileCount);
		}


	}
}
