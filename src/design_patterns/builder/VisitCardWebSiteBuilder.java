package design_patterns.builder;

public class VisitCardWebSiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        webSite.setName("VisitCard");
    }

    @Override
    void buildCms() {
        webSite.setCms("WordPress");
    }

    @Override
    void buildPrice() {
        webSite.setPrice(500);
    }
}
