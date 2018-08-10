package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LandingPage;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LandingTopMenuPageNavigationTests extends TestBase{

    @Test
    public void asUserNavigateFromLandingToTopMenuPage(){
        DriverUtils.navigateToPage(APPLICATION_URL);

        LandingPage landingPage = new LandingPage();
        boolean isSignOnLinkDisplayed = landingPage
                .clickOnEnterStoreLink()
                .isSignOnLinkDisplayed();

        assertTrue(isSignOnLinkDisplayed);
    }
}