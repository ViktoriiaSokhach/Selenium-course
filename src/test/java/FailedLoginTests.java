import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.TopMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        //Ustawienie ścieżki do WebDrivera Chrome
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        //Inicliazjacja ChromeDriver
        driver = new ChromeDriver();

        //Ustawienie Implicit Wait na 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Przejśćie do strony sklepu
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {

        //Zamknięcie okna przeglądarki
        driver.close();

        //Zabicie procesu WebDrivera
        driver.quit();
    }

}