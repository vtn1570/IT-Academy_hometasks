package by.it.voytsekhovskiy.jd01_02;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[][] resultOfStep1 = step1(n);
//        step2(resultOfStep1);
//        step3(resultOfStep1);
//    }

    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        Random random = new Random();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                int newNumber = random.nextInt(11) - 5;
                arr[i][j] = newNumber;
                System.out.print(arr[i][j] + " ");
            }
        }
        return arr;
    }

    static int step2(int[][] arr) {
        boolean openCount = false;
        int entering = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            openCount = false;
            entering = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    if (entering == 0) {
                        entering = arr[i][j];
                        openCount = true;
                        continue;
                    } else {
                        break;
                    }
                }

                if (openCount) {
                    sum = sum + arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println(sum);
        System.out.println();
        return sum;
    }


    static int[][] step3(int[][] arr) {
        int maxNumberOfArray = arr[0][0];
        int lengthOfArrayOfMaxNumbers = 0;
        int[] indexOfMaxNumber = new int[lengthOfArrayOfMaxNumbers];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxNumberOfArray) {
                    maxNumberOfArray = arr[i][j];
//                    indexOfMaxNumber[0] = i;
//                    indexOfMaxNumber[1] = j;
                }
            }
        }

        int nextStepInFoundingIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == maxNumberOfArray) {
                    lengthOfArrayOfMaxNumbers = lengthOfArrayOfMaxNumbers + 2;
                    indexOfMaxNumber[nextStepInFoundingIndex] = i;
                    indexOfMaxNumber[nextStepInFoundingIndex + 1] = j;
                    nextStepInFoundingIndex = nextStepInFoundingIndex + 2;
                }
            }
        }

        int changeNumberOfColumns = 0;
        int changeNumberOfLine = 0;
        int sizeOfArray = arr.length-1;
        int[][] returnArray = new int[sizeOfArray][sizeOfArray];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (indexOfMaxNumber[0] != i && indexOfMaxNumber[1] != j) {
                    int positionOfLine = i;
                    int positionOfColumn = j;
                    if(j >= indexOfMaxNumber[1]) {
                        int positionOfColumn1 = j - changeNumberOfColumns < 0 ? 0 : j - changeNumberOfColumns;
                        positionOfColumn = positionOfColumn1;
                    }
                     if(i >= indexOfMaxNumber[0]) {
                        int positionOfLine1 = i - changeNumberOfLine < 0 ? 0 : i - changeNumberOfLine;
                         positionOfLine = positionOfLine1;
                    }
                     returnArray[positionOfLine][positionOfColumn] = arr[i][j];

                } else {

                    if (indexOfMaxNumber[0] == i) {
                        changeNumberOfLine = 1;

                    }
                    if(indexOfMaxNumber[1] == j) {
                        changeNumberOfColumns = 1;
                    }
                }
            }
        }

        for (int i = 0; i < returnArray.length; i++) {
            System.out.println();
            for (int j = 0; j < returnArray[i].length; j++) {
                System.out.print(returnArray[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println("max number of array is:" + maxNumberOfArray);
        System.out.println("Index of max number is:" + Arrays.toString(indexOfMaxNumber));
        return arr;
    }
}
