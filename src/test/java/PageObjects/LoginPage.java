package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoUserNameField(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("NotExistingLogin");
    }

    public void typeIntoPasswordField(){
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("NotProperPassword");
    }

    public void clickOnLoginButton(){
        WebElement signOnButton = driver.findElement(By.name("signon"));
        signOnButton.click();
    }

    public String getWarningMessage(){
        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        String warningText = messageLabel.getText();
        return warningText;
    }
}
