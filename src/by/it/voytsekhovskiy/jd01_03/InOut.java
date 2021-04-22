package by.it.voytsekhovskiy.jd01_03;


import java.util.Arrays;

public class InOut {

    static double[] getArray(String line) {
        String[] stringArray = line.split(" ");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    static void printArray(double[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(name);
            System.out.printf("%1d=%-10.2f", i, arr[i] );
            if(i % columnCount == 0 ) {
                System.out.println();
            }
        }
    }
}
