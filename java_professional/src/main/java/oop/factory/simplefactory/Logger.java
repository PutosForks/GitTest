package oop.factory.simplefactory;

enum LogType {
    DATABASE, FILE
}


public interface Logger {
    void log(String message);
}

class FileLogger implements Logger {

    public void log(String message) {
        System.out.println("Logging into file");
    }

}

class DatabaseLogger implements Logger {

    public void log(String message) {
        System.out.printf("Logging %s into database", message);
    }

}

class LoggerFactory {

    public static Logger getInstance(LogType log) {

        Logger logger = null;
        switch (log) {
            case DATABASE:
                logger = new DatabaseLogger();
                break;
            default:
                logger = new FileLogger();
                break;
        }

        return logger;
    }
}


class LoggerTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getInstance(LogType.DATABASE);
        logger.log("bla, bla, bla");
    }
}

