package tests;

import static navigation.ApplicationURLs.TOP_MENU_PAGE_URL;
import static org.testng.Assert.assertEquals;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        DriverUtils.navigateToPage(TOP_MENU_PAGE_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        String warningMessage = topMenuPage
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout()
                .getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}