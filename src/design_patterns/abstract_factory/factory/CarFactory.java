package design_patterns.abstract_factory.factory;

import design_patterns.abstract_factory.Engine;
import design_patterns.abstract_factory.Tyre;
import design_patterns.abstract_factory.car.CarEngine;
import design_patterns.abstract_factory.car.CarTyre;
import design_patterns.abstract_factory.truck.TruckTyre;

public class CarFactory extends Factory {
    @Override
    public Engine getEngine() {
        return new CarEngine();
    }

    @Override
    public Tyre getTyre() {
        return new CarTyre();
    }
}
