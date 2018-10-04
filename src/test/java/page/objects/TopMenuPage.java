package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @FindBy(css = "#QuickLinks img")
    private WebElement fishImageButton;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Sign on Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        logger.info("Clicked on Sign on Link");
        return new LoginPage();
    }

    @Step("Getting is Sign On Link is displayed")
    public boolean isSignOnLinkDisplayed() {
        WaitForElement.waitUntilElementIsVisible(signOnLink);
        boolean isDisplayed = signOnLink.isDisplayed();
        logger.info("Sign On Link is Displayed: {}", isDisplayed);
        return isDisplayed;
    }

    @Step("Click on Fish Image Button")
    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(fishImageButton);
        fishImageButton.click();
        logger.info("Clicked on Fish Image Button");
        return new FishListPage();
    }
}