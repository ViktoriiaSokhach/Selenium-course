import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElementTest() {

        WebElement checkbox = driver.findElement(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeButton = driver.findElement(By.cssSelector("button#btn"));
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement infoMessage = driver.findElement(By.cssSelector("p#message"));

        assertEquals(infoMessage.getText(), "It's gone!");
    }

    @Test
    public void waitForPresenceOfTheElementTest() {

        WebElement checkboxBeforeClick = driver.findElement(By.id("checkbox"));

        assertTrue(checkboxBeforeClick.isDisplayed());
        assertFalse(checkboxBeforeClick.isSelected());

        WebElement removeOrAddButton = driver.findElement(By.id("btn"));
        removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkboxBeforeClick);

        WebElement infoMessage = driver.findElement(By.cssSelector("p#message"));

        assertEquals(infoMessage.getText(), "It's gone!");

        removeOrAddButton.click();

        WebElement checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
