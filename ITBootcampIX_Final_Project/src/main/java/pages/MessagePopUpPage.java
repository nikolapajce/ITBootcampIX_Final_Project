package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {

        this.driver = driver;
    }
    private WebDriverWait wait;
    public void waitForPopUpToBeVisible(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }
    public String getMessageTextFromPopUp(){
        return driver.findElement(By.tagName("li")).getText();
    }

    public WebElement getCloseButtonFromPopUp(){
        return driver.findElement(By.xpath("//*[text()='Close']"));
    }
    public void waitForSuccessPopUpToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
    public String getMessageTextFromSuccessPopUp(){
        return driver.findElement(By.className("success")).getText();
    }



    public void waitForVerifyAccountPopUpToBeVisible (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }

    public String getMessageTextFromVerifyAccountPopUp(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]")).getText();
    }

    public WebElement getCloseButtonFromVerifyAccountPopUp(){
        return driver.findElement(By.className("btnClose"));
    }
}
