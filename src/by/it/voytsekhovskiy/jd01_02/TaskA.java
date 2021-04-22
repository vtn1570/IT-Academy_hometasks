package by.it.voytsekhovskiy.jd01_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length ; i++) {
            int p = sc.nextInt();
            arr[i] = p;
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    static void step1(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        System.out.println(min + " " + max);
    }

    static void step2(int[] array) {
        double average = 0;
        for (int i = 0; i <array.length ; i++) {
            average = average + array[i];
        }
        average = average / array.length;
        for (int i = 0; i <array.length ; i++) {
            if(array[i] < average) {
                System.out.print(array[i] + " ");
            }
        }
    }

    static void step3(int[] array) {
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("");
        for (int i = array.length - 1; i >= 0 ; i--) {
            if(array[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

}
