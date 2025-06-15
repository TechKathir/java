package multithreading;

public class Practice implements Runnable, Comparable<Practice> {
    int count = 0;

    public void print(String d) {
        System.out.println("Hello " + d);
    }

    public static void main(String[] args) {
        Practice p1 = new Practice();
        Thread thread = new Thread(p1, "THE ONE");
        Thread thread2 = new Thread(p1, "THE TWO");
        thread.start();
        thread2.start();
        System.out.println("completed");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        p1.print("p1");
//        p3.print("p3");
    }

    @Override
    public void run() {
        System.out.println("Called - "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            System.out.println("Completed - "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int compareTo(Practice o) {
        return 0;
    }
}
