package by.it.voytsekhovskiy.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NullPointerException | NumberFormatException e) {
            Class<? extends RuntimeException> exceptionStructure = e.getClass();
            String nameExceptionClass = exceptionStructure.getName();
            Class<TaskA> runnerStructure = TaskA.class;
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
        }
    }
}
