package by.it.voytsekhovskiy.jd01_15;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {
    private static File currentDir = new File(FileNameHelper.getFilePath("", TaskC.class));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String line = sc.nextLine();
            if (!line.equals("end")) {
                commandLineApplication(line);
            } else {
                break;
            }
        }
    }


    private static void commandLineApplication(String line) {
        if (line.startsWith("cd")) {
            String[] split = line.split("\\s");
            if (split.length <= 1) {
                System.out.println(currentDir);
                return;
            }
            if (split[1].equals("..")) {
                getParent();
            } else {
                getDir(split[1]);
            }
        } else if (line.equals("dir")) {
            Arrays.stream(Objects.requireNonNull(currentDir.list()))
                    .forEach(System.out::println);
        }
    }

    private static void getParent() {
        currentDir = currentDir.getParentFile();
        System.out.println(currentDir);
    }

    private static void getDir(String dirName) {
        File newDir = new File(TaskC.currentDir.toString() + File.separator + dirName);
        if (newDir.exists()) {
            currentDir = newDir;
            System.out.println(currentDir);
        } else {
            System.out.println("This directory don't exist!");
        }
    }
}
