package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest{

    @Test (priority = 100)
    public void visitsTheLoginPage(){
        navPage.getChangeLanguageButton().click();
        navPage.getENButton().click();
        loginPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[ERROR] URL does not contain /login");

    }
}
