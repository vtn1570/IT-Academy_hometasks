package by.it.voytsekhovskiy.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPerson = sc.nextInt();
        String[] arraySecondName = new String[numberOfPerson];
        for (int i = 0; i < arraySecondName.length; i++) {
            String secondName = sc.next();
            arraySecondName[i] = secondName;
        }

        int[][] payment = new int[numberOfPerson][4];
        for (int i = 0; i < arraySecondName.length; i++) {
            System.out.println("Введите зарплату для " + arraySecondName[i]);
            for (int j = 0; j < 4; j++) {
                int quarterPayment = sc.nextInt();
                payment[i][j] = quarterPayment;
            }
        }

        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < arraySecondName.length; i++) {
            System.out.printf("%7s: ", arraySecondName[i]);
            for (int j = 0; j < 5 ; j++) {
                if (j != 4) {
                    System.out.printf("%-10d", payment[i][j]);
                } else {
                    System.out.printf("%-5d\n", payment[i][0]+payment[i][1]+payment[i][2]+payment[i][3]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < payment.length; i++) {
            for (int j = 0; j < payment[i].length; j++) {
                sum = sum + payment[i][j];
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-8s %-5d\n", "Итого", sum);
        System.out.printf("%-8s %-6.4f", "Итого", (double)sum / (payment.length * payment[0].length));
    }
}
