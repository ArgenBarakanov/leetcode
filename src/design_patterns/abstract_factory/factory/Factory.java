package design_patterns.abstract_factory.factory;

import design_patterns.abstract_factory.Engine;
import design_patterns.abstract_factory.Tyre;

public abstract class Factory {

    public abstract Engine getEngine();

    public abstract Tyre getTyre();

    public static Factory getFactory(String type) {
        if (type == null) {
            return null;
        }
        Factory factory = null;
        switch (type) {
            case "car":
                factory = new CarFactory();
                break;
            case "truck":
                factory = new TruckFactory();
                break;
        }
        return factory;
    }
}
