package by.it.voytsekhovskiy.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";

    public static void main(String[] args) {
        String filePath = FileNameHelper.getFilePath(MATRIX_TXT, TaskA.class);
        Integer[][] matrix = fillRandom();
        String strMatrix = matrixToString(matrix);
        saveTxtMatrix(filePath, strMatrix);
        fileToConsole(filePath);
    }

    private static void fileToConsole(String path) {
        try {
            Files.lines(Paths.get(path))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String matrixToString(Integer[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (Integer[] row : matrix) {
            for (Integer element : row) {
                sb.append(String.format(("%3d"), element))
                        .append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void saveTxtMatrix(String path, String str) {
        try (
                PrintWriter pw = new PrintWriter(
                        new FileWriter(path)
                )
        ) {
            pw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer[][] fillRandom() {
        Integer[][] matrix = new Integer[6][4];
        Random random = new Random();
        for (Integer[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + random.nextInt(31);
            }
        }
        return matrix;
    }
}
