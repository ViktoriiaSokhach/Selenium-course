import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/hovers");
    }

    @Test
    public void hoverTest() {

        WebElement firstUserAvatar = driver.findElement(By.xpath("//div[@class='example']/div[1]"));
        WebElement secondUserAvatar = driver.findElement(By.xpath("//div[@class='example']/div[2]"));
        WebElement thirdUserAvatar = driver.findElement(By.xpath("//div[@class='example']/div[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstUserAvatar).perform();

        WebElement firstUserCaption = driver.findElement(By.xpath("//*[@class='example']/div[1]/div/h5"));
        WebElement secondUserCaption = driver.findElement(By.xpath("//*[@class='example']/div[2]/div/h5"));
        WebElement thirdUserCaption = driver.findElement(By.xpath("//*[@class='example']/div[3]/div/h5"));

        assertEquals(firstUserCaption.getText(),"name: user1");
        assertEquals(secondUserCaption.getText(), "");
        assertEquals(thirdUserCaption.getText(), "");

        actions.moveToElement(secondUserAvatar).perform();

        assertEquals(firstUserCaption.getText(), "");
        assertEquals(secondUserCaption.getText(), "name: user2");
        assertEquals(thirdUserCaption.getText(), "");

        actions.moveToElement(thirdUserAvatar).perform();

        assertEquals(firstUserCaption.getText(), "");
        assertEquals(secondUserCaption.getText(), "");
        assertEquals(thirdUserCaption.getText(), "name: user3");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
