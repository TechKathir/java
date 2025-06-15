package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class CallableFuture {


//    public static void main(String[] args) throws Exception {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        Future<String> future = executor.submit(() -> {
//            Thread.sleep(3000); // Simulate delay
//            return "Hello from Future";
//        });
//
//        System.out.println("Doing other work in main...");
//
//        // BLOCKING call - waits until result is ready
//        String result = future.get();
//        System.out.println("Result: " + result);
//        executor.shutdown();
//    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Running task " + taskId + " on " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        Thread.sleep(100);
        System.out.println("--------------------");
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(() -> {
            IntStream.range(1, 6).parallel().forEach(i -> {
                System.out.println("Running task " + i + " on " + Thread.currentThread().getName());
            });
        }).join();
    }

}

class Person {
    private String name;
    private boolean side = true; // true = left, false = right

    public Person(String name) {
        this.name = name;
    }

    public void tryToPass(Person other) {
        while (this.side == other.side) {
            System.out.println(name + ": Oh, you go ahead...");
            // Change side to let other pass
            this.side = !this.side;
            try {
                Thread.sleep(100); // Simulate time taken to step aside
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + ": Passed through the hallway.");
    }
}

