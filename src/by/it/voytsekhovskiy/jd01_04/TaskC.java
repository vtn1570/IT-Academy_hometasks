package by.it.voytsekhovskiy.jd01_04;

import java.util.Arrays;

public class TaskC {


//    static void mergeSort(double[] array) {
//        if(array.length <= 1) {
//            return;
//        } else {
//
//        }
//    }
//
//
//    static void printArray1(double[] arr, String name, int columnCount) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("V[% 2d ]=%-10.2f", i, arr[i] );
//            if(i % columnCount == 0 ) {
//                System.out.println();
//            }
//        }
//    }
//    static void buildOneDimArray(String line) {
//        String[] lineArray = line.split(" ");
//        double[] doubleArray = new double[lineArray.length];
//        for (int i = 0; i < lineArray.length; i++) {
//            doubleArray[i] = Double.parseDouble(lineArray[i]);
//        }
//
//        double firstNumber = doubleArray[0];
//        double lastNumber = doubleArray[doubleArray.length - 1];
//        printArray1(doubleArray, "V", 5);
//        printArray1(doubleArray, "V", 4);
//        System.out.println();
//        for (int i = 0; i < doubleArray.length; i++) {
//            if(doubleArray[i] == firstNumber) {
//                System.out.println("Index of first element=" + i);
//            } else if (doubleArray[i] == lastNumber) {
//                System.out.println("Index of last element=" + i);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] array1 = { 8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43 };
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    /**
     *
     * @param buffer1 Массив для сортировки.
     * @param buffer2 Буфер. Размер должен быть равен размеру buffer1.
     * @param startIndex Начальный индекс в buffer1 для сортировки.
     * @param endIndex Конечный индекс в buffer1 для сортировки.
     * @return
     */
    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
