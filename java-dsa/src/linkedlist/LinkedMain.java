package linkedlist;

import java.util.Iterator;

public class LinkedMain {

    public static void main(String[] args) {
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(1);
        singleLinked.add(2);
        singleLinked.add(3);
        singleLinked.add(4);
        singleLinked.add(6);
        singleLinked.add(68);
        singleLinked.print();
        singleLinked.reverse();
        System.out.println("----");
        singleLinked.print();
//        System.out.println(singleLinked.get(0));
//        System.out.println(singleLinked.get(1));
//        System.out.println(singleLinked.get(2));
//        singleLinked.print();
    }
}
