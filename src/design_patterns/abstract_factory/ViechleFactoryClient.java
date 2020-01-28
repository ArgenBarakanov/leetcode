package design_patterns.abstract_factory;

import design_patterns.abstract_factory.factory.Factory;

public class ViechleFactoryClient {
    public static  void main(String[] args){
        Factory factory = Factory.getFactory("car");
        factory.getEngine().design();
        factory.getEngine().manufacture();
        factory.getEngine().test();

        factory.getTyre().manufacture();
        factory.getTyre().design();
    }
}
