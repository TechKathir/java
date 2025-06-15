package annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        RefEx o = createClass();
//        o.age = 100;
//        o.name = "Hello";
        System.out.println(o.age);
        System.out.println(o.name);
//        Class<?> clazz =  o.getClass();
//
//        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
//        method.setAccessible(true); // access private
//
//        int result = (int) method.invoke(o, 5, 3);
//        System.out.println("Result: " + result); // 8
//        System.out.println("Field name");
//        for (Field declaredField : clazz.getDeclaredFields()) {
//            System.out.println(declaredField.getName());
//        }
//        System.out.println("Methods");
//        for (Method method : clazz.getMethods()) {
//            System.out.println(method.getName());
//        }
//        System.out.println("Super class");
//        System.out.println(clazz.getSuperclass().getName());
//        System.out.println("Interfaces");
//        for (Class<?> anInterface : clazz.getInterfaces()) {
//            System.out.println(anInterface.getName());
//        }
    }

    public static RefEx createClass() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = RefEx.class;
        // Get constructor with (int, String)
        Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class);
        RefEx o = (RefEx) constructor.newInstance(2,"1212");
        return o;
    }
}



class RefExSup{
    int sup;
    public void printSup(){
        System.out.println("Sup class print");
    }
}

interface RefInterface{
    String inter = "Sample RefInterface";
    default void printInter(){
        System.out.println("Interface print");
    }
}

class RefEx extends RefExSup implements RefInterface{
    int age = 90;
    String name ="Hello";
    public void printSub(){
        System.out.println("Sub class print");
    }
    private int add(int a, int b) {
        return a + b;
    }
}
