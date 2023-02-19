package pages;
// Login Page
// Polje za unos email-a
// Polje za unos lozinke
// Dugme za login.


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    public LoginPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
    }
    public WebElement getEmailInput () {
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput () {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.xpath("//button[@type = 'submit']"));
    }
}
