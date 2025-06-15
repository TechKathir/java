package priorityqueue;

import java.util.Arrays;

public class PqueueMain {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(Arrays.asList(12, 5, 1, 45, 67, 4, 2, 3, 4, 10));
        System.out.println("-------  " + queue.toString());
        queue.poll();

        queue.poll();
        queue.remove(12);
        queue.remove(3);
        queue.poll();
        queue.remove(6);
        System.out.println(queue.isValidMinHeap());
        queue.remove(6);
        queue.insert(11);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(0);
    }
}
