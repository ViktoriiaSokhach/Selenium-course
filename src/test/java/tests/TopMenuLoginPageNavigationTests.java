package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.TOP_MENU_PAGE_URL;
import static org.testng.Assert.assertTrue;

public class TopMenuLoginPageNavigationTests extends TestBase {

    @Test
    public void asUserNavigateFromTopMenuToLoginPage(){
        DriverUtils.navigateToPage(TOP_MENU_PAGE_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        boolean isUsernameFieldDisplayed = topMenuPage
                .clickOnSignInLink()
                .isUsernameFieldDisplayed();

        assertTrue(isUsernameFieldDisplayed);
    }
}