package annotation;

import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void validateEmpty(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(NotEmpty.class)){
                field.setAccessible(true);
                Object o = field.get(obj);
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                if(o == null){
                    throw new RuntimeException(field.getAnnotation(NotEmpty.class).message());
                }
            }else {
                System.out.println("Not present");
            }
        }
    }
}
