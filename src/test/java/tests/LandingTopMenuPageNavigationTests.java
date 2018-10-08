package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LandingPage;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.Assert.assertTrue;

public class LandingTopMenuPageNavigationTests extends TestBase{


    @TmsLink("ID-3")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to navigate from LandingPage to TopMenuPage ")
    public void asUserNavigateFromLandingToTopMenuPage(){
        DriverUtils.navigateToPage(APPLICATION_URL);

        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink()
                .assertThatSignOnLinkIsDisplayed();
    }
}