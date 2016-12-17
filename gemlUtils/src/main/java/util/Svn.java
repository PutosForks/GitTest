package util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Svn {

    private static Logger logger;

    static {
        logger = Logger.getLogger(Svn.class);
    }

    public Svn() {
    }

    public Svn(String command, String file) {
        runCommand(command, file);
    }

    public void runCommand(String command, String file) {

        Path path = Paths.get(file);
        String execCMD = command + " " + path.toAbsolutePath();
        logger.info(execCMD);

        try {
            Process p = Runtime.getRuntime().exec(execCMD);
            p.waitFor();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }

        } catch (IOException | InterruptedException e1) {
            logger.error(e1);
        }
    }
}
