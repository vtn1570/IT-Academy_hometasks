package by.it.voytsekhovskiy.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Helper {

    public static void sort(double[] arr) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
        }
        while (swap);
        System.out.println(Arrays.toString(arr));
    }


    public static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static double[]mul(double[][] matrix, double[] vector) {
        double[] vectorArray = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                double multiplication = matrix[i][j] * vector[j];
                vectorArray[i] = vectorArray[i] + multiplication;
            }
        }
        return vectorArray;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                double sum = 0;
                for (int j1 = 0; j1 < matrixRight.length; j1++) {
                    sum = sum + (matrixLeft[i][j1] * matrixRight[j1][j]);
                    resultMatrix[i][j] = sum;
                }

            }
        }
        return resultMatrix;
    }
}
