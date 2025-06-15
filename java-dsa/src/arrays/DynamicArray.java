package arrays;

public class DynamicArray<T> {
    private T[] array;
    private Integer size;
    private Integer capacity;


    public int size() {
        return this.size;
    }

    public DynamicArray() {
        this.size = 0;
        this.array = (T[]) new Object[2];
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    private void increaseArrSize() {
        T[] newArr = (T[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public void add(T data) {
        if (size == array.length) {
            System.out.println("Size equals");
            increaseArrSize();
        }
        array[size++] = data;
    }


}
