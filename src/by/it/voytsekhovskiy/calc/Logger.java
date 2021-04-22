package by.it.voytsekhovskiy.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum Logger {
    INSTANCE;

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    static private final String logName = "log.txt";

    Logger() {
    }

    String log(String message) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(dir(), true)
        )) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }


    static private synchronized String dir() {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + logName;
    }
}
