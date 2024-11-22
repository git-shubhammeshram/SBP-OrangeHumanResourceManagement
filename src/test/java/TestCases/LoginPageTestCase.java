package TestCases;

import Base.TestBase;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTestCase extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void openBrowser() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserLoginToApplicationWithValidCredentialsTest() {
        /*
        Login Test Case:
            Open the OrangeHRM login page.
            Enter valid credentials.
            Click the login button.
            Verify successful login by checking the dashboard page title.
        */
        String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actResult = loginPage.loginToApplication("Admin", "admin123");
        Assert.assertEquals(expResult, actResult);
    }

    @Test
    public void verifyUserLoginToApplicationWithInvalidCredentialsTest() {
        /*
        Login Test Case:
            Open the OrangeHRM login page.
            Enter invalid credentials.
            Click the login button.
            Verify login failure by checking the error message.
        */

        String actResult = loginPage.loginToApplicationWithInvalidUserData("admin","admin");
        Assert.assertEquals("Invalid credentials", actResult);
    }



    @Test(dependsOnMethods = "verifyUserLoginToApplicationWithValidCredentialsTest")
    public void verifyUserLogoutToApplication() {
        String expResult = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPage.loginToApplication("Admin", "admin123");
        String actResult = loginPage.logoutToApplication();
        Assert.assertEquals(expResult, actResult);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
