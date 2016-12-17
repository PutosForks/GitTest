package util;

import csv.FuncListDb;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesCopy {

    private static Logger logger;

    static {
        logger = Logger.getLogger(FuncListDb.class);
    }

    public FilesCopy(File source, File target) {
        try {
            logger.info(System.getProperty("user.dir"));
            Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
            logger.info(source.getName() + " copied");
        } catch (IOException e) {
            logger.error(e);

        }
    }
}
