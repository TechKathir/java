package behaviouralpatterns.mementopattern;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.update("Hello, World!");
        System.out.println(textEditor.getText());
        textEditor.save();
        textEditor.update("Update 1");
        System.out.println(textEditor.getText());
        textEditor.undo();
        System.out.println("after undo "+textEditor.getText());
    }
}

class Memento {
    private final String snapshot;

    public Memento(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getSnapshot() {
        return this.snapshot;
    }
}

class History {
    private final Stack<Memento> history = new Stack<>();

    public void push(Memento memento) {
        System.out.println("Saving : "+ memento.getSnapshot());
        history.push(memento);
        System.out.println("history len - "+ history.size());
    }

    public Memento undo() {
        return history.pop();
    }
}


class TextEditor {
    private String text;
    private final History history = new History();
    public String getText(){
        return this.text;
    }
    public void update(String text) {
        this.text = text;
    }

    public void save() {
        history.push(new Memento(text));
    }

    public void undo() {
        text = history.undo().getSnapshot();
    }
}