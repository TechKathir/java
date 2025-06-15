package creationalpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton logger = Singleton.getInstance();
        logger.log("Hello World");
    }
}

class Singleton {
    private static Singleton logger;

    private Singleton() {
    }

//    Duplicate instance will be created in multiple thread try to access at the same time
//    public static Singleton getInstance(){
//        if(logger == null){
//            return new Singleton();
//        }
//        return logger;
//    }

    //    Make the null checking logic sync
    public static Singleton getInstance() {
        if (logger == null) {
            synchronized (Singleton.class) {
                if (logger == null) {
                    return new Singleton();
                }
            }
            return logger;
        }
        return logger;
    }

    public void log(String string) {
        System.out.println("LOG: " + string);
    }
}
