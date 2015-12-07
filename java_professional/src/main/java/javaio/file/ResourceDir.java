package javaio.file;

import java.io.File;


public class ResourceDir {
  public static File getResourceDir () {
	  String currentDir = System.getProperty("user.dir");
	  String resorceDir = currentDir + "\\src\\main\\resources\\";
	  return new File(resorceDir);

  }

}
