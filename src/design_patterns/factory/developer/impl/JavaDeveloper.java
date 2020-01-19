package design_patterns.factory.developer.impl;

import design_patterns.factory.developer.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Jvm deals with all memory issues. Dont worry.");
    }
}
