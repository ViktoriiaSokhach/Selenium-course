package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.TOP_MENU_PAGE_URL;
import static org.testng.Assert.assertTrue;

public class TopMenuLoginPageNavigationTests extends TestBase {

    @TmsLink("ID-4")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to navigate from TopMenuPage to LoginPage")
    public void asUserNavigateFromTopMenuToLoginPage(){
        DriverUtils.navigateToPage(TOP_MENU_PAGE_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        boolean isUsernameFieldDisplayed = topMenuPage
                .clickOnSignInLink()
                .isUsernameFieldDisplayed();

        assertTrue(isUsernameFieldDisplayed);
    }
}