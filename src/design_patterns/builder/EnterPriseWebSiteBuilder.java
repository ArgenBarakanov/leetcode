package design_patterns.builder;

public class EnterPriseWebSiteBuilder extends WebSiteBuilder {
    @Override
    void buildName() {
        webSite.setName("Corporate");
    }

    @Override
    void buildCms() {
        webSite.setCms("Alifresko");
    }

    @Override
    void buildPrice() {
       webSite.setPrice(10000);
    }
}
