class Result {

    public static void main(String[] args) throws InterruptedException {
        Bedroom bedroom = new Bedroom();
        Bathroom bathroom = new Bathroom();
        Kitchen kitchen = new Kitchen();

        bedroom.accept(new DecorateVisitor());
        bathroom.accept(new CleaningVisitor());
        kitchen.accept(new DecorateVisitor());
    }

}

interface Visitor {
    void visit(Bedroom bedroom);
    void visit(Bathroom bathroom);
    void visit(Kitchen kitchen);
}

interface Visit{
    void accept(Visitor visitor);
}

class CleaningVisitor implements Visitor{

    @Override
    public void visit(Bedroom bedroom) {
        System.out.println("Cleaning bed room");
    }

    @Override
    public void visit(Bathroom bathroom) {
        System.out.println("Cleaning bath room");
    }

    @Override
    public void visit(Kitchen kitchen) {
        System.out.println("Cleaning kitchen");
    }
}


class DecorateVisitor  implements Visitor{

    @Override
    public void visit(Bedroom bedroom) {
        System.out.println("Decorating bed room");
    }

    @Override
    public void visit(Bathroom bathroom) {
        System.out.println("Decorating bath room");
    }

    @Override
    public void visit(Kitchen kitchen) {
        System.out.println("Decorating kitchen");
    }
}

// clean, decorate
class Bedroom implements Visit{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class Bathroom implements Visit{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class Kitchen implements Visit{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}