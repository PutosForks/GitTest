package org.stringdata.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesCopy {

    public FilesCopy(File source, File target) {
        try {
            Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
