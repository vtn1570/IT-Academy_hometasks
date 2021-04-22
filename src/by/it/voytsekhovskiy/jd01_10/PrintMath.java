package by.it.voytsekhovskiy.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        fieldsToString();
        methodsToString();
    }

    static void fieldsToString() {
        Class<Math> mathClass = Math.class;
        Field[] fieldsOfMath = mathClass.getDeclaredFields();
        for (Field field : fieldsOfMath) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) { // checking is the object public
                StringBuilder resultString = new StringBuilder();
                Class<?> typeField = field.getType(); // double, int ...
                String nameField = field.getName();
                resultString.append(typeField)
                        .append(" ")
                        .append(nameField);
                System.out.println(resultString);
            }
        }
    }

    static void methodsToString() {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) { // checking is the object public
                StringBuilder resultString = new StringBuilder();

                String methodModifier = Modifier.toString(method.getModifiers()); // public static
                resultString.append(methodModifier)
                        .append(" ");

                String returnTypeOfMethod = method.getReturnType().getSimpleName(); // double, float, int...
                resultString.append(returnTypeOfMethod)
                        .append(" ");

                String nameOfMethod = method.getName();
                resultString.append(nameOfMethod)
                        .append("(");

                Class<?>[] typeParameters = method.getParameterTypes(); // type of parameter
                if (typeParameters.length != 0) { // check isEmpty?
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (i != typeParameters.length - 1) {
                            resultString.append(typeParameters[i])
                                    .append(",");
                        } else {
                            resultString.append(typeParameters[i])
                                    .append(")");
                        }
                    }
                } else {
                    resultString.append(")");
                }
                System.out.println(resultString);
            }
        }
    }
}
