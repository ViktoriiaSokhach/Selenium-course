package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_PAGE_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {


    @Issue("DEFECT-1")
    @TmsLink("ID-2")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

}