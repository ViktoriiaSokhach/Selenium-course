import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetPageTitleTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumhq.org/");
    }

    @Test
    public void getPageTitleTest() {
        String pageTitle = driver.getTitle();

        assertEquals(pageTitle, "Selenium - Web Browser Automation");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}
