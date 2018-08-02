package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @FindBy(css = "#QuickLinks img")
    private WebElement fishImageButton;

    private WebDriver driver;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSignInLink() {
        signOnLink.click();
    }

    public void clickOnFishImageButton() {
        fishImageButton.click();
    }
}