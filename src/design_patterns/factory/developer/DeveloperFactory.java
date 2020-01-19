package design_patterns.factory.developer;

import design_patterns.factory.developer.impl.DefaultDeveloper;
import design_patterns.factory.developer.impl.JavaDeveloper;
import design_patterns.factory.developer.impl.PhpDeveloper;

public class DeveloperFactory {
    public static Developer createDeveloper(String type) {
        switch (type) {
            case "java":
                return new JavaDeveloper();
            case "php":
                return new PhpDeveloper();
            default:
                return new DefaultDeveloper();
        }
    }
}
