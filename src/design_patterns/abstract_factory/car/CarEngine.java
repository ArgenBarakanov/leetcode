package design_patterns.abstract_factory.car;

import design_patterns.abstract_factory.Engine;

public class CarEngine implements Engine {
    @Override
    public void manufacture() {
        System.out.println("Выпускаем двигатель для машин");
    }

    @Override
    public void design() {
        System.out.println("Разрабатываем двигатель для машин");
    }

    @Override
    public void test() {
        System.out.println("Тестируем двигатель для машин");
    }
}
