package by.it.voytsekhovskiy.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        List<Double> arrayFromScanner = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String line = sc.nextLine();
            if (!line.equals("END")) {
                try {
                    arrayFromScanner.add(Double.parseDouble(line));
                    Double sum = 0.0;
                    for (Double element : arrayFromScanner) {
                        sum = element + sum;
                    }
                    if (sum > 0) {
                        System.out.println(Math.sqrt(sum));
                    } else {
                        throw new ArithmeticException();
                    }

                } catch (NumberFormatException | ArithmeticException e) {
                    Class<? extends RuntimeException> exceptionStructure = e.getClass();
                    String nameExceptionClass = exceptionStructure.getName();
                    Class<TaskB> runnerStructure = TaskB.class;
                    String nameRunnerClass = runnerStructure.getName();
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String stackTraceClassName = stackTraceElement.getClassName();
                        if (stackTraceClassName.equals(nameRunnerClass)) {
                            int lineNumber = stackTraceElement.getLineNumber();
                            System.out.printf("" +
                                            " name: %s\n" +
                                            "class: %s\n" +
                                            " line: %d\n",
                                    nameExceptionClass, nameRunnerClass, lineNumber
                            );
                            break;
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }
    }
}
