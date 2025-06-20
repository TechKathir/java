package linkedlist;

import java.util.Iterator;

public class SingleLinked implements ILinkedList, Iterable<Integer> {

    private Node head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int value) {
        if (isEmpty()) {
            head = new Node(value);
        } else {
            Node nodeAt = getNodeAt(size - 1);
            nodeAt.nextNode = new Node(value);
        }
        size++;
    }

    @Override
    public void add(int index, int value) {
        if (index == 0) {
            head = new Node(head.nextNode, value);
        }
        Node nodeAt = getNodeAt(index - 1);
        Node nextNode = nodeAt.nextNode;
        nodeAt.nextNode = new Node(nextNode, value);
        size++;
    }


    @Override
    public boolean remove(int index) {
        if (index == 0) {
            head = head.nextNode;
        } else {
            Node nodeAt = getNodeAt(index - 1);
            nodeAt.nextNode = nodeAt.nextNode.nextNode;
        }
        size--;
        return true;
    }

    @Override
    public int get(int index) {
        return getNodeAt(index).value;
    }

    @Override
    public void insert(int index, int value) {
        getNodeAt(index).value = value;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
    }

    private Node getNodeAt(int index) {
        validateIndex(index);
        if (index == 0) {
            return head;
        }
        int tempIdx = 0;
        Node current = head;
        while (tempIdx < index) {
            current = current.nextNode;
            tempIdx++;
        }
        return current;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.nextNode;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SingleLinkListIterator();
    }

    private class Node {
        private int value;
        private Node nextNode;

        public Node(Node nextNode, int value) {
            this.nextNode = nextNode;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    private class SingleLinkListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int value = current.value;
            current = current.nextNode;
            return value;
        }
    }

    public void reverse() {
        Node temp = head;
        Node perv = null;
        while (temp != null){
            Node nextNode = temp.nextNode;
            temp.nextNode = perv;
            perv = temp;
            temp = nextNode;
        }
        head = perv;
    }

}
