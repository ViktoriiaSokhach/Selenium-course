package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {

        LandingPage landingPage = new LandingPage();
        String warningMessage = landingPage
                .clickOnEnterStoreLink()
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout()
                .getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}