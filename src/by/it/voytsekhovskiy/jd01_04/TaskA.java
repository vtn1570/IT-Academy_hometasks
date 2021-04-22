package by.it.voytsekhovskiy.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10 ; i++) {
            for (int j = 2; j < 10 ; j++) {
                System.out.printf("%1d*%1d=%-3d",i, j ,i*j);
            }
            System.out.println();
        }
    }

    static void printArray1(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("V[% 2d ]=%-10.2f", i, arr[i] );
            if(i % columnCount == 0 ) {
                System.out.println();
            }
        }
    }

    public static void sort1(double[] arr) {
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

    static void buildOneDimArray(String line) {
        String[] lineArray = line.split(" ");
        double[] doubleArray = new double[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            doubleArray[i] = Double.parseDouble(lineArray[i]);
        }

        double firstNumber = doubleArray[0];
        double lastNumber = doubleArray[doubleArray.length - 1];
        printArray1(doubleArray, "V", 5);
        sort1(doubleArray);
        printArray1(doubleArray, "V", 4);
        System.out.println();
        for (int i = 0; i < doubleArray.length; i++) {
            if(doubleArray[i] == firstNumber) {
                System.out.println("Index of first element=" + i);
            } else if (doubleArray[i] == lastNumber) {
                System.out.println("Index of last element=" + i);
            }
        }
    }
}
