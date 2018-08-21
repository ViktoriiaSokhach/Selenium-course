package navigation;

import configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String TOP_MENU_PAGE_URL = APPLICATION_URL + "actions/Catalog.action";
    public static final String LOGIN_PAGE_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
}

