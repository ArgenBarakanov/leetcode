package design_patterns.abstract_factory.truck;

import design_patterns.abstract_factory.Engine;

public class TruckEngine implements Engine {

    @Override
    public void manufacture() {
        System.out.println("Выпускаем двигатель для грузовиков");
    }

    @Override
    public void design() {
        System.out.println("Разрабатываем двигатель для грузовиков");
    }

    @Override
    public void test() {
        System.out.println("Тестируем двигатель для грузовиков");
    }
}
