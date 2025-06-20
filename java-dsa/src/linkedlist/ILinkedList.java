package linkedlist;

public interface ILinkedList {
    void add(int value);
    void add(int index, int value);
    boolean remove(int index);
    int get(int index);
    void insert(int index, int value);
}
