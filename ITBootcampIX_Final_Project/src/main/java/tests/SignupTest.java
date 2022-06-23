package tests;

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
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"), "email",
                "[Error] Input field is not email");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"), "password",
                "[Error] Input field is not password");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"), "password",
                "[Error] Input field is not password");
    }
    @Test (priority = 300)
    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.getSignupButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getMessageFromPopUp(), "E-mail already exists",
                "[Error] Pop up message not correct");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL does not contain /signup");
    }
    @Test (priority = 400)
    public void signUp(){
        String name = "Nikola Pavlovic";
        String email = "nikola.pavlovic@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.getSignupButton().click();
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignUpButton().click();
        messagePopUpPage.waitForVerifyAccountPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getMessageFromVerifyAccountPopUp(), "IMPORTANT: Verify your account",
                "[Error] Pop up message not correct");
        messagePopUpPage.getCloseButtonFromVerifyAccountPopUp().click();
        navPage.getLogoutButton().click();
    }
}
