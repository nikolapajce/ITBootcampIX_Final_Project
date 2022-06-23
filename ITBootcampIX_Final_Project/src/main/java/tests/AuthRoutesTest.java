package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BasicTest{
    @Test(priority = 100)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {
        driver.navigate().to(baseUrl + "home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
    }
    @Test(priority = 200)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() throws InterruptedException {
        driver.navigate().to(baseUrl + "profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
    }
    @Test(priority = 300)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
        driver.navigate().to(baseUrl + "admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
    }
    @Test(priority = 400)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
        driver.navigate().to(baseUrl + "admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "[Error] URL does not contain /login");
    }
}
