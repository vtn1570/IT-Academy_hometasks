package by.it.voytsekhovskiy.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> bean = Bean.class;
        Object o = bean.getConstructor().newInstance(); // create instance of class Bean
        Method[] declaredMethods = bean.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method.getName());
                System.out.println(method.invoke(o,2,5));
            }
        }
    }
}
