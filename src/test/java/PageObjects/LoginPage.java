package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Adding parameter (username) to make the method more generic and maintainable (applicable for many tests)
    public void typeIntoUserNameField(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    // Adding parameter (password) to make the method more generic and maintainable (applicable for many tests)
    public void typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton() {
        signOnButton.click();
    }

    public String getWarningMessage() {
        String warningText = messageLabel.getText();
        return warningText;
    }
}

