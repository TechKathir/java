package creationalpatterns.factorypattern;

public class VehicleFactory {

    //    In future may be increase in types EG: 200 types of vehicle's it violates the open-close principle
    public static Vehicle getVehicleInstance(String type) {
        if (type.equals("CAR")) {
            return new Car();
        } else if (type.equals("BIKE")) {
            return new Bike();
        }
        throw new RuntimeException("Unknown vehicle type: " + type);
    }

}
