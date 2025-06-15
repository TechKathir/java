package creationalpatterns.abstractfactory;

import creationalpatterns.factorypattern.Vehicle;

public class Main {
//    Advantage of Abstract Factory is scalable compared to factory Pattern
    public static void main(String[] args) {
        AbstractVehicleFactory carFactory = new CarFactory();
        AbstractVehicleFactory bikeFactory = new BikeFactory();
        Vehicle car = carFactory.createVehicle();
        Vehicle bike = bikeFactory.createVehicle();
        bike.start();
        bike.stop();
        car.start();
        car.stop();
    }
}
