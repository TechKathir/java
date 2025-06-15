package annotation;

import java.lang.reflect.Field;

public class Injector {
    public static void inject(Object o) throws InstantiationException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        for (Field declaredField : clazz.getDeclaredFields()) {
            if(declaredField.isAnnotationPresent(AutoWried.class)){
                declaredField.setAccessible(true);
                Object o1 = declaredField.getType().newInstance();
                declaredField.set(o, o1);
            }
        }
    }
}
