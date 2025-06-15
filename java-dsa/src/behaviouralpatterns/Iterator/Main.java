package behaviouralpatterns.Iterator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskList list = new TaskList(List.of("1","2","3","4","5"));
        while (list.hasNext()){
            System.out.println(list.next());
        }
    }
}

interface Iterator<T>{
    boolean hasNext();
    T next();
}

class TaskList implements Iterator<String>{
    int idx = 0;
    List<String> tasks;

    public TaskList(List<String> tasks){
        this.tasks = tasks;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < tasks.size();
    }

    @Override
    public String next() {
        return tasks.get(idx++);
    }
}
