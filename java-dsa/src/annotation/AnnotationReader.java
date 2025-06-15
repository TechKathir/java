package annotation;

import java.lang.reflect.Method;

public class AnnotationReader {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Main.class;
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
            if (method.isAnnotationPresent(MyLog.class)) {
                MyLog log = method.getAnnotation(MyLog.class);
                System.out.println("Annotation value: " + log.value());
            }
        }
    }
}

