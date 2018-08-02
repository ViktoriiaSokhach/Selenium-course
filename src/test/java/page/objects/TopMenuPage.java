package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @FindBy(css = "#QuickLinks img")
    private WebElement fishImageButton;

    // When I created DriverManager class I had to delete this line:
    // private WebDriver driver

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
    }

    public void clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(fishImageButton);
        fishImageButton.click();
    }
}