package javaio.ByteStreams.inout;

import javaio.file.ResourceDir;

import java.io.*;

public class ReadWriteUsingByteArray {
	public static void main(String[] args) {
		File resource = ResourceDir.getResourceDir();
		File pdf = new File(resource, "\\pdf\\JFXST.pdf");
		File pdfCopy = new File(resource, "\\pdf\\JFXST3.pdf");


		try {
			InputStream in = new FileInputStream(pdf);
			OutputStream out = new FileOutputStream(pdfCopy);

          int data;
			byte [] byteArray = new byte[1024];

			while ((data = in.read(byteArray)) != -1) {
				out.write(byteArray,0,data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
