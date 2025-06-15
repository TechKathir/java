package creationalpatterns.factorypattern;

import static creationalpatterns.factorypattern.VehicleFactory.getVehicleInstance;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = getVehicleInstance("BIKE");
        Vehicle car = getVehicleInstance("CAR");
        bike.start();
        bike.stop();
        car.start();
        car.stop();
    }
}
