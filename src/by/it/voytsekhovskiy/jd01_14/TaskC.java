package by.it.voytsekhovskiy.jd01_14;

import java.io.*;

public class TaskC {
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";


    public static void main(String[] args) {
        String resultStr = null;
        try {
            resultStr = readFiles(new File(pathToSecondName()).listFiles());
            System.out.println(resultStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        loadToTxt(resultStr);
    }


    private static void loadToTxt(String str) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(pathToWorkPackage(TaskC.class) + "resultTaskC.txt")
        )) {
            pw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFiles(File[] files) throws FileNotFoundException {
        if (files != null) {
            StringBuilder sb = new StringBuilder();
            for (File f : files) {
                if (f.isDirectory()) {
                    String strFromInternalMethod = readFiles(new File(f.getAbsolutePath()).listFiles());
                    sb.append(strFromInternalMethod);
                    sb.append("dir:")
                            .append(f.getName())
                            .append("\n");
                } else if (f.isFile()) {
                    sb.append("file:")
                            .append(f.getName())
                            .append("\n");
                }
            }
            return sb.toString();
        }
        throw new FileNotFoundException();
    }

    private static String pathToSecondName() {
        String src = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String pathPackage = "by" + File.separator + "it" + File.separator + "voitsekhovskiy";
        return src + pathPackage;
    }

    private static String pathToWorkPackage(Class<?> cl) {
        String src = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return src + clDir;
    }
}
