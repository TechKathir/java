package corejava;

public class HelloWorld {
    public static void main(String[] args) {
        Ref ref = new Ref();
        Sup.Hel hel = new Sup.Hel();
        Sup.Hel hel2 = new Sup.Hel();
        System.out.println(Sup.Hel.d);
        Sup.Hel.d = 9999;
        System.out.println(Sup.Hel.d);
        System.out.println(hel.d);
        System.out.println(hel2.d);

        //        System.out.println(Sup.Hel.);
    }

}

interface Int1{
    void print();
}


interface Int2{
    default void print(){
        System.out.println("default");
    };
}

class Sup {
    int a = 10;
   Sup(){
       this.a = 12;
   }
   static class Hel{
      static int d = 121212;
   }
}

class Ref extends Sup{

}

