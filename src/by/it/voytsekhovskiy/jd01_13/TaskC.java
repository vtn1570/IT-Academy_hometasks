package by.it.voytsekhovskiy.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
        public static Scanner sc;
    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        List<Double> numbers = new ArrayList<>();
        int attemptCount = 0;
        for (; ; ) {
            String line = sc.nextLine();
            try {
                numbers.add(Double.parseDouble(line));
            } catch (NumberFormatException e) {
                attemptCount = attemptCount + 1;
                Thread.sleep(100);
                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.print(numbers.get(i) + " ");
                    if (i == 0) {
                        System.out.println();
                    }
                }
                if (attemptCount == 5) {
                    throw e;
                }
            }
        }
    }
}
