package javaio.ByteStreams.inout;

import javaio.file.ResourceDir;

import java.io.*;


public class ReadWriteFiles {
	public static void main(String[] args) {

		File resource = ResourceDir.getResourceDir();
		File pdf = new File(resource, "\\pdf\\JFXST.pdf");
		File pdfCopy = new File(resource, "\\pdf\\JFXST2.pdf");

		try {
			InputStream in = new FileInputStream(pdf);
			OutputStream out = new FileOutputStream(pdfCopy);

			int data;
			while ((data = in.read())
					!= -1) {
              out.write(data);
			}

		} catch (IOException e) {
            e.printStackTrace();
		}

	}
}
