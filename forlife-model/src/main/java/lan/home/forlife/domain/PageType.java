package lan.home.forlife.domain;

public enum PageType {
    ARTICLE("/api/articles", "Article"),
    MAIN_PAGE("/api/mainpages", "Main page");

    private String baseUrl;
    private String pageDescription;
    PageType(String baseUrl, String pageDescription) {
        this.baseUrl=baseUrl;
        this.pageDescription=pageDescription;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPageDescription() {
        return pageDescription;
    }
}
