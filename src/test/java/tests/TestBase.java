package tests;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    // Note: field 'driver' changes from public to protected
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = DriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //adding new action for a browser
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}