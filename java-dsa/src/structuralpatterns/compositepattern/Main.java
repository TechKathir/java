package structuralpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        Folder folder = new Folder("java");
        Folder folder2 = new Folder("spring");
        folder.addFile(file1);
        folder.addFile(file2);
        folder2.addFile(file3);
        folder.addFile(folder2);
        folder.open();
    }
}

interface FileAction {
    void open();
}

class File implements FileAction {
    private final String name;

    public File(String name) {
        this.name = name;
    }


    @Override
    public void open() {
        System.out.println("Open: " + name);
    }
}

class Folder implements FileAction {
    private final String folderName;
    List<FileAction> files;

    public Folder(String folderName) {
        this.folderName = folderName;
        files = new ArrayList<>();
    }

    public void addFile(FileAction fileAction) {
        files.add(fileAction);
    }

    public void open() {
        System.out.println("Open: " + folderName);
        for (FileAction fileAction : files) {
            fileAction.open();
        }
    }
}
