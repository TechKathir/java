package creationalpatterns.abstractfactory;

import creationalpatterns.factorypattern.Bike;
import creationalpatterns.factorypattern.Vehicle;

public class BikeFactory implements AbstractVehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
