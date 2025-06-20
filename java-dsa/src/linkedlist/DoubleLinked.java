package linkedlist;

import java.util.Iterator;

public class DoubleLinked implements ILinkedList, Iterable<Integer> {

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(int value) {
        add(size, value);
    }

    @Override
    public void add(int index, int value) {
        validateIndex(index);
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.nextNode = head;
            if (head != null) head.pevNode = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        } else if (size == index) {
            newNode.pevNode = tail;
            if (tail != null) tail.nextNode = newNode;
            tail = newNode;
            if (head == null) head = newNode;
        } else {
            Node nodeAt = getNodeAt(index);
            Node pevNode = nodeAt.pevNode;
            newNode.nextNode = nodeAt;
            newNode.pevNode = pevNode;
            nodeAt.pevNode = newNode;
            pevNode.nextNode = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(int index) {
        validateIndex(index);
        if (index == 0) {
            head = head.nextNode;
        } else if (index == size - 1) {
            tail = tail.pevNode;
        } else {
            Node nodeAt = getNodeAt(index);
            Node pevNode = nodeAt.pevNode;
            Node nextNode = nodeAt.nextNode;
            pevNode.nextNode = nextNode;
            nextNode.pevNode = pevNode;
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
        validateIndex(index);
        if (index == 0) {
            head.value = value;
        } else if (size == index) {
            tail.value = value;
        } else {
            Node nodeAt = getNodeAt(index);
            nodeAt.value = value;
        }
    }

    private Node getNodeAt(int index) {
        validateIndex(index);
        if (index == 0) {
            return head;
        }
        Node current = head;
        int tempIdx = 0;
        while (tempIdx < index) {
            current = current.nextNode;
            tempIdx++;
        }
        return current;
    }

    private void validateIndex(int index) {
        if (index < size || index > size) throw new IndexOutOfBoundsException("Index ut of bounce");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DoubleLinkedIterator();
    }

    public void print(){
        Node current = head;
        while (current != null){
            System.out.println(current.value);
            current = current.nextNode;
        }
    }

    private class DoubleLinkedIterator implements Iterator<Integer> {
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

    private class Node {
        private int value;
        private Node nextNode;
        private Node pevNode;

        public Node(int value) {
            this.value = value;
        }
    }
}
