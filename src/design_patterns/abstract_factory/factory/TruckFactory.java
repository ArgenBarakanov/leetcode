package design_patterns.abstract_factory.factory;

import design_patterns.abstract_factory.Engine;
import design_patterns.abstract_factory.Tyre;
import design_patterns.abstract_factory.truck.TruckEngine;
import design_patterns.abstract_factory.truck.TruckTyre;

public class TruckFactory extends Factory {
    @Override
    public Engine getEngine() {
        return new TruckEngine();
    }

    @Override
    public Tyre getTyre() {
        return new TruckTyre();
    }
}
