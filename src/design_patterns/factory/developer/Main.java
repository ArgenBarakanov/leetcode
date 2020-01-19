package design_patterns.factory.developer;

public class Main {
    public static void main(String[] args){
        Developer javaDev= DeveloperFactory.createDeveloper("java");
        javaDev.write();

        Developer phpDev = DeveloperFactory.createDeveloper("php");
        phpDev.write();

        Developer unknownDev = DeveloperFactory.createDeveloper("");
        unknownDev.write();
    }
}
