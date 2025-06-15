package behaviouralpatterns.visitorpattern;

public class Main {
    public static void main(String[] args) {
        BedRoom bedRoom = new BedRoom();
        bedRoom.accept(new Cleaning());
        bedRoom.accept(new Decorating());
        BathRoom bathRoom = new BathRoom();
        bathRoom.accept(new Cleaning());
        bathRoom.accept(new Decorating());
    }
}

interface Room {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(BedRoom room);

    void visit(BathRoom room);
}

class Cleaning implements Visitor {
    @Override
    public void visit(BedRoom room) {
        System.out.println("Cleaning bedroom");
    }

    @Override
    public void visit(BathRoom room) {
        System.out.println("Cleaning bathroom");
    }
}

class Decorating implements Visitor {
    @Override
    public void visit(BedRoom room) {
        System.out.println("Decorating bedroom");
    }

    @Override
    public void visit(BathRoom room) {
        System.out.println("Decorating bathroom");
    }
}

class BedRoom implements Room {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BathRoom implements Room {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
