package linkedlist;

public class DoubleLinked {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public int getLast() {
        return tail.value;
    }

    public void dummy() {
        System.out.println("head curr - " + head.value);
        System.out.println("head next - " + head.nextNode.value);
        System.out.println("tail curr - " + tail.value);
        System.out.println("tail pev - " + tail.pevNode.value);
    }

    public void add(int i) {
        if (size == 0) {
            Node node = new Node();
            node.value = i;
            head = node;
            tail = node;
        } else {
            Node node = new Node();
            node.value = i;
            node.nextNode = head;
            head.pevNode = node;
            head = node;
//            System.out.println(head.value);
//            System.out.println("nex node - "+ head.nextNode.value);
        }
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.nextNode;
            --size;
            return;
        }
        int count = 1;
        Node temp = head.nextNode;
        while (count < index) {
            System.out.println("count - " + count);
            System.out.println("index - " + index);
            if (count == (index - 1)) {
                System.out.println("inside");
                temp.nextNode = temp.nextNode.nextNode;
                temp.nextNode.pevNode = temp;
                break;
            }
            temp = temp.nextNode;
            count++;
        }
        --size;
    }

    public int get(int index) {
        if (index == 0) return head.value;
        int count = 1;
        Node temp = head.nextNode;
        while (count != index) {
            temp = temp.nextNode;
            System.out.println("count - " + count);
            System.out.println("index - " + index);
            count++;
        }
        return temp.value;
    }

    public void print() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            System.out.println(temp.value);
//            System.out.println("prv - " + temp.pevNode.value);
//            System.out.println("next - " + temp.nextNode.value);
            temp = temp.nextNode;
            count++;
        }
    }

    private class Node {
        private int value;
        private Node nextNode;
        private Node pevNode;
    }
}
