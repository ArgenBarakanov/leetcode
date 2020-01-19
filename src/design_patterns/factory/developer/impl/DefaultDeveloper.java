package design_patterns.factory.developer.impl;

import design_patterns.factory.developer.Developer;

public class DefaultDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("I write programs on C++");
    }
}
