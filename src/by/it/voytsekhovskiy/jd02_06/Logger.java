package by.it.voytsekhovskiy.jd02_06;
// Singletone


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    private static volatile Logger logger;
    private final String logName = "log.txt";

    private Logger() {
    }

    void log(String message) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(dir(), true)
        )) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = logger = new Logger();
                }
            }
        }
        return local;
    }

    private synchronized String dir() {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + logName;
    }
}
