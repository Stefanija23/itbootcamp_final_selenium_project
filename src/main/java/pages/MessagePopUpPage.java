package pages;
//metodu koja ceka da pop up bude vidljiv
//Elemente koji u sebi sadrze tekstove poruke
//Close dugme
//metodu koja ceka da se verify your account dijalog pojavi
//metodu koja vraca zaglavlje iz verify your account dijaloga koji sadrzi tekst IMPORTANT: Verify your account
//Close dugme iz verify account dijaloga



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void waitForPopUpToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'v-snack__content')]")));
    }
    public WebElement getPopUpMessage() {
        return driver.findElement(By.xpath("//div[@role = 'status']//li"));
    }
    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[@role = 'status']//button"));
    }
    public void waitVerifyMessageToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }
    public WebElement getVerifyCloseButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }
    public WebElement getCloseButtonFromVerifyAccount() {
        return driver.findElement(By.xpath("//div[contains(@class, 'success')]"));
    }
}
