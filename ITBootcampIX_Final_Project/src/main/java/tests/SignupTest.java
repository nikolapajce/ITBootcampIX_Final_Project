package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BasicTest{
    @Test (priority = 100)
    public void visitsTheSignupPage() throws InterruptedException {
        navPage.getSignupButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
    }
    @Test (priority = 200)
    public void checkInputTypes(){
        navPage.getSignupButton().click();
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("type"), "email",
                "[Error] Input field is not email");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("type"), "password",
                "[Error] Input field is not password");
        Assert.assertEquals(driver.findElement(By.id("confirmPassword")).getAttribute("type"), "password",
                "[Error] Input field is not password");
    }
}
