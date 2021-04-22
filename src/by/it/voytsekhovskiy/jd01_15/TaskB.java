package by.it.voytsekhovskiy.jd01_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// 1 однострочный
// 2 однострочный

/*
 1
 многострочный
 */

/*
 2
 многострочный
 */

/**
 * javaDoc
 * javaDoc
 */

public class TaskB {

    public static final String TASK_B_JAVA = "TaskB.java";
    public static final String TASK_B_TXT = "TaskB.txt";

    public static void main(String[] args) {
        String pathToJava = FileNameHelper.getFilePath(TASK_B_JAVA, TaskB.class);
        String pathToTxt = FileNameHelper.getFilePath(TASK_B_TXT, TaskB.class);

        String strWithoutComments = deleteComments(fileToString(pathToJava));
        saveStringInTxt(pathToTxt, strWithoutComments);
        System.out.println(strWithoutComments);
    }

    private static void saveStringInTxt(String path, String str) {
        try {
            Files.write(Paths.get(path), str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fileToString(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(path))
                    .forEach(el -> sb.append(el).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String deleteComments(String str) {
        str = str.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)", "");
        return str;
    }
}
