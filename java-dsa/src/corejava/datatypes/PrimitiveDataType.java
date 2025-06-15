package corejava.datatypes;

import org.openjdk.jol.info.ClassLayout;

class Person {
    int age = 25;
    double height = 5.9;
    String name = "John";
    String name2 = null;
}

public class PrimitiveDataType {



    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());
    }


}
