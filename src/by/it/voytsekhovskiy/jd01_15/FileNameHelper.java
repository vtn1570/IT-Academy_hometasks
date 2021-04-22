package by.it.voytsekhovskiy.jd01_15;

import java.io.File;

public class FileNameHelper {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";


    static String getFilePath(String filename, Class<?> cl) {
        String src = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return src + clDir + filename;
    }
}
