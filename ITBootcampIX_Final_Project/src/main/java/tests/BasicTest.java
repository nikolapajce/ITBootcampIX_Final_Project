package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        signupPage = new SignupPage(driver);
        citiesPage = new CitiesPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }


    @AfterMethod
    public void afterMethod() {
        //Screenshot
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
