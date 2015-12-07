package javaio.ByteStreams.inout;

import javaio.file.ResourceDir;

import java.io.*;

/**
 * Created by 502413934 on 7.12.2015.
 */
public class BufferedReadWriteFiles {
	public static void main(String[] args) {
		File resource = ResourceDir.getResourceDir();
		File pdf = new File(resource, "\\pdf\\JFXST.pdf");
		File pdfCopy = new File(resource, "\\pdf\\JFXST4.pdf");

		try {
			BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(pdf));
			BufferedOutputStream bfo = new BufferedOutputStream((new FileOutputStream(pdfCopy)));

			int data;
			while ((data = bfi.read()) != -1 ) {
				bfo.write(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
