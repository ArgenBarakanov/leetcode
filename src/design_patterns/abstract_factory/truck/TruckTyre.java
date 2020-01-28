package design_patterns.abstract_factory.truck;

import design_patterns.abstract_factory.Tyre;

public class TruckTyre implements Tyre {
    @Override
    public void manufacture() {
        System.out.println("Производим шины для грузовиков");
    }

    @Override
    public void design() {
        System.out.println("Разрабатываем шины для грузовиков");
    }
}
