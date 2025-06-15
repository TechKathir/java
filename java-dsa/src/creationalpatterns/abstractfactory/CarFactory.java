package creationalpatterns.abstractfactory;

import creationalpatterns.factorypattern.Car;
import creationalpatterns.factorypattern.Vehicle;

public class CarFactory implements AbstractVehicleFactory{

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
