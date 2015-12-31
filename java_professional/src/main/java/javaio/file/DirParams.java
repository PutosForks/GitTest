package javaio.file;

import java.io.File;
import java.io.FilenameFilter;

public class DirParams {

    public static void main(String[] args) {
        DirParams dp = new DirParams();
        dp.printDirParams();
        File[] f = dp.getNewTextFiles(".png");

        for (File fl : f) {
            System.out.println(fl.getName());
        }
    }

    public void printDirParams() {
        File f = ResourceDir.getResourceDir();

        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        try {
            System.out.println(f.getCanonicalPath());        // validated against File System
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File[] getNewTextFiles() {
        File dir = ResourceDir.getResourceDir();
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".png");
            }
        });
    }

    private File[] getNewTextFiles(final String extension) {
        File dir = ResourceDir.getResourceDir();
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension);
            }
        });
    }

}
