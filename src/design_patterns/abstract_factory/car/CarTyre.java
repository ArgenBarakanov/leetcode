package design_patterns.abstract_factory.car;

import design_patterns.abstract_factory.Tyre;

public class CarTyre implements Tyre {
    @Override
    public void manufacture() {
        System.out.println("Производим шины для машин");
    }

    @Override
    public void design() {
        System.out.println("Разрабатываем шины для машин");
    }
}
