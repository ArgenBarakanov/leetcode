package design_patterns.factory.developer.impl;

import design_patterns.factory.developer.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Why do you hate php? It is absolutely normal tool for web.");
    }
}
