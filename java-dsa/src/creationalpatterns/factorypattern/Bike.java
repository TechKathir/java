package creationalpatterns.factorypattern;

public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike Start");
    }

    @Override
    public void stop() {
        System.out.println("Bike Stop");
    }
}
