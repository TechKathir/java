package linkedlist;

public class LinkedMain {

    public static void main(String[] args) {
        DoubleLinked d = new DoubleLinked();
        d.add(1); // 4
        d.add(2); // 3
        d.add(3); // 2
        d.add(4); // 1
        d.add(5); // 0
        d.remove(3);
        System.out.println("-----");
        d.print();
//        System.out.println(d.getLast());
//        d.remove(4);
//        System.out.println("--------------");
    }
}
