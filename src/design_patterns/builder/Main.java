package design_patterns.builder;

public class Main {
    public static void main(String[] args){
        Director director = new Director();
        director.setWebSiteBuilder(new EnterPriseWebSiteBuilder());
        WebSite webSite = director.createWebSite();
        System.out.println(webSite.toString());
    }
}
