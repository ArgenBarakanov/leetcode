package design_patterns.builder;

public abstract class WebSiteBuilder {
    WebSite webSite;

    public void createSite(){
        webSite = new WebSite();
    }

    abstract void buildName();

    abstract void buildCms();

    abstract void buildPrice();

    public WebSite getWebSite(){
        return this.webSite;
    }
}
