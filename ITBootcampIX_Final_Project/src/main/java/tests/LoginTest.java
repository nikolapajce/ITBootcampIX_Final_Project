package tests;

import org.openqa.selenium.By;
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
    @Test (priority = 200)
    public void checkInputTypes(){
        navPage.getLogInButton().click();
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("type"), "email", "[Error] Input field is not email");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("type"), "password", "[Error] Input field is not password");
    }
}
