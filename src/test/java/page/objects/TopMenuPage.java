package page.objects;

import driver.manager.DriverManager;
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

    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        logger.info("Clicked on Sign on Link");
        return new LoginPage();
    }

    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(fishImageButton);
        fishImageButton.click();
        logger.info("Clicked on Fish Image Button");
        return new FishListPage();
    }
}