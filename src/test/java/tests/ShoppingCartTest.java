package tests;

import static navigation.ApplicationURLs.TOP_MENU_PAGE_URL;
import static org.testng.Assert.assertEquals;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestBase {

    @TmsLink("ID-5")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is to make sure that not logged in user" +
            " can not proceed to checkout")
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        DriverUtils.navigateToPage(TOP_MENU_PAGE_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        LoginPage loginPage = topMenuPage
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout();
        loginPage
                .assertThatWarningIsDisplayed("You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}