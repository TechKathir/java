package linkedlist;

public class SingleLinked {

    private Node head;
    private int size;

    public int size() {
        return size;
    }

    public void add(int i) {
        if (head == null) {
            Node node = new Node();
            node.value = i;
            head = node;
//            System.out.println(head.value);
        } else {
            Node node = new Node();
            node.value = i;
            node.nextNode = head;
            head = node;
//            System.out.println(head.value);
//            System.out.println("nex node - "+ head.nextNode.value);
        }
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.nextNode;
            return;
        }
        int count = 1;
        Node temp = head.nextNode;
        while (count <= index) {
            System.out.println("count - " + count);
            System.out.println("index - " + index);
            if (count == (index - 1)) {
                System.out.println("inside");
                System.out.println("temp - " + temp);
                if (temp.nextNode != null) {
                    temp.nextNode = temp.nextNode.nextNode;
                }
                break;
            }
            temp = temp.nextNode;
            count++;
        }
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
            System.out.println("idx - " + count + " value - " + temp.value);
            temp = temp.nextNode;
            count++;
        }
    }

    private class Node {
        private int value;
        private Node nextNode;
    }
}
