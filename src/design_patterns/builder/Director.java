package design_patterns.builder;

public class Director {
    WebSiteBuilder webSiteBuilder;

    public void setWebSiteBuilder(WebSiteBuilder webSiteBuilder) {
        this.webSiteBuilder = webSiteBuilder;
    }

    WebSite createWebSite(){
        webSiteBuilder.createSite();
        webSiteBuilder.buildName();
        webSiteBuilder.buildCms();
        webSiteBuilder.buildPrice();
        return webSiteBuilder.getWebSite();
    }
}
