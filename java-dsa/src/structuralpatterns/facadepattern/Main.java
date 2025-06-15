package structuralpatterns.facadepattern;

public class Main {
    public static void main(String[] args) {
        // Client has to do all the work -> without facade
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SurroundSound sound = new SurroundSound();
        dvd.on();
        projector.on();
        sound.on();
        dvd.play();
//        With facade
        HomeTheaterFacade home = new HomeTheaterFacade();
        home.watchMovie();  // ✅ Just one method to use everything
    }
}

class DVDPlayer {
    void on() {
        System.out.println("DVD Player ON");
    }

    void play() {
        System.out.println("Playing Movie");
    }
}

class Projector {
    void on() {
        System.out.println("Projector ON");
    }
}

class SurroundSound {
    void on() {
        System.out.println("Surround Sound ON");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SurroundSound sound;

    public HomeTheaterFacade() {
        dvd = new DVDPlayer();
        projector = new Projector();
        sound = new SurroundSound();
    }

    public void watchMovie() {
        dvd.on();
        projector.on();
        sound.on();
        dvd.play();
    }
}
