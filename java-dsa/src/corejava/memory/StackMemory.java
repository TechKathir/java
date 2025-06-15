package corejava.memory;

import java.time.LocalDate;

class Memory{
    String name  = "Kathir";
    int age=10;
    Integer height= 2;
    static int staticVariable = 1212;
    static Integer staticVariable2 = 1212;
    String parentName = String.valueOf("John");
    final LocalDate dob = LocalDate.of(1990, 1, 1);
    final int finalVariable = 12;
}

public class StackMemory {
    public static void main(String[] args) {
        int a = 10; // primitive stored in stack
        int b = 20;
        int result = add(a, b);  // method call → new stack frame
        System.out.println(result);
        Runnable task = () -> {
                int x = 1 / 0; // will cause ArithmeticException
        };
        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");
        t1.start();
        t2.start();
    }

    static int add(int x, int y) {
        int sum = x + y; // x, y, sum all in this method's stack frame
        return sum;
    }

}
