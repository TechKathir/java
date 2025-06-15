package filehandling;

import java.io.*;

public class FileHandling {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        FileReader fileReader = new FileReader("D:\\learning\\dsa\\java-dsa\\src\\filehandling\\test.txt");
//        try(BufferedReader br = new BufferedReader(fileReader)){
//            List<String> lines = br.lines().toList();
//            System.out.println(lines.toString());
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }

//        Creating a file

//        boolean newFile = file.createNewFile();
//        System.out.println(newFile ? "File created successfully" : "File already exists");
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("sample.txt", true));
//        writer.write("Appending with BufferedWriter\n");
//        writer.close();

//        PrintWriter writer = new PrintWriter("sample.txt");
//        writer.println("Created using PrintWriter");
//        writer.println(223);
//        writer.println('f');
//        writer.close();
//        WriteSample sample = new WriteSample();
//        FileOutputStream fos = new FileOutputStream("writeSample.ser");
//        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
//        outputStream.writeObject(sample);
//        sample.print();
        try(FileInputStream fis = new FileInputStream("writeSample.ser")){
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            WriteSample o = (WriteSample)inputStream.readObject();
            System.out.println(o.name);
            o.print();
        }finally {
            System.out.println("nhjgjjghjhjg");
        }
    }
}

class WriteSample implements Serializable{
    @Serial
    private static final long serialVersionUID = 2L;
    String name = "Hello";
    int age = 20;
    transient String skip = "sdsjd";

    public void print(){
        System.out.println("Helsdsdssdlo");
    }
}

class WriteSample2 implements Serializable{
    String name = "Hello";
    int age = 20;
    transient String skip = "sdsjd";
}