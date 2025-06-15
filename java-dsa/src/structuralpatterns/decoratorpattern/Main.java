package structuralpatterns.decoratorpattern;

public class Main {
    public static void main(String[] args) {
        CoffeeActions coffee = new Coffee();
        coffee = new MilkCoffee(coffee);
        coffee = new ExtraSugar(coffee);
        System.out.println("Cost: "+coffee.getCost());
        System.out.println("Description: "+coffee.description());
    }
}

interface CoffeeActions {
    String description();

    int getCost();
}

class Coffee implements CoffeeActions {
    @Override
    public String description() {
        return "Basic Coffee";
    }

    @Override
    public int getCost() {
        return 10;
    }
}

class MilkCoffee implements CoffeeActions {
    private final CoffeeActions coffee;

    public MilkCoffee(CoffeeActions coffee) {
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description() + " -> Adding Milk";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 2;
    }
}

class ExtraSugar implements CoffeeActions {
    private final CoffeeActions coffee;

    public ExtraSugar(CoffeeActions coffee) {
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description() + " -> Adding sugar";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 1;
    }
}