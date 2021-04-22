package by.it.voytsekhovskiy.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {

    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    public static void main(String[] args) {
        String path = dir(TaskA.class) + DATA_TASK_A_BIN;
        saveIntegers(path);
        List<Integer> list = getIntegers(path);
        printToTxt(printConsole(list));
    }


    private static void printToTxt(String numbers) {
        try (
                PrintWriter pw = new PrintWriter( // ????
                        new BufferedWriter(
                                new FileWriter(dir(TaskA.class) + RESULT_TASK_A_TXT))
                )
        ) {
            pw.write(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String printConsole(List<Integer> array) {
        StringBuilder outputString = new StringBuilder();
        double sum = 0;
        int count = 0;
        for (Integer el : array) {
            count = count + 1;
            sum = sum + el;
            outputString.append(el).append(" ");
        }
        outputString.append("\n")
                .append("avg=")
                .append(sum / count);
        System.out.println(outputString);
        return outputString.toString();
    }


    private static List<Integer> getIntegers(String path) {
        List<Integer> numbers = new ArrayList<>();
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(path)
                        )
                )
        ) {
            while (dis.available() > 0) { // ??? dis.read() != -1 ( почему не работает?)
                numbers.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }


    private static String dir(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }


    private static void saveIntegers(String path) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(path)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int num = (int) (Math.random() * 1000);
                dos.writeInt(num);
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
