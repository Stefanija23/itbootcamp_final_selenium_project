package pages;
//        Home link
//        About link
//        My profile link
//        Admin dugme
//        Cities link iz padajuceg Admin menija
//        Users link iz padajuceg Admin menija
//        Sign up dugme
//        Login dugme
//        Logout dugme
//        Dugme za izbor jezika
//        EN dugme iz padajuceg menija za izbor jezika
//        ES dugme iz padajuceg menija za izbor jezika
//        FR dugme iz padajuceg menija za izbor jezika
//        CN dugme iz padajuceg menija za izbor jezika


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public NavPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }


    public WebElement getHomeLink (){
        return driver.findElement(By.xpath("//a[@href = '/']"));
    }
    public WebElement getAboutLink () {
        return driver.findElement(By.xpath("//a[@href = '/about']"));
    }

    public WebElement getMyProfileLink () {
        return driver.findElement(By.xpath("//a[@href = '/profile']"));
    }
    public WebElement getAdminButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin hidden-sm-and-down v-btn v-btn--text theme--light v-size--default')]"));
    }
    public WebElement getCitiesLink () {
        return driver.findElement(By.xpath("//a[@href = '/admin/cities']"));
    }
    public WebElement getUsersLink () {
        return driver.findElement(By.xpath("//a[@href = '/admin/users']"));
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.xpath("//a[@href = '/login']"));
    }
    public WebElement getLogoutButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'hidden-sm-and-down btnLogout v-btn v-btn--text theme--light v-size--default')]"));
    }
    public WebElement getSignupButton () {
        return driver.findElement(By.xpath("//a[@href = '/signup']"));
    }
    public WebElement getLanguageButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation v-btn v-btn--text theme--light v-size--default')]"));
    }
    public WebElement getEnglishButton () {
        return driver.findElement(By.id("list-item-245"));
    }
    public WebElement getSpanishButton () {
        return driver.findElement(By.id("list-item-247"));
    }
    public WebElement getFrenchButton () {
        return driver.findElement(By.id("list-item-249"));
    }
    public WebElement getChineseButton () {
        return driver.findElement(By.id("list-item-251"));
    }
    public WebElement getHeader() {
        return driver.findElement(By.xpath("//div[@class='layout row wrap']/div/h1"));
    }
}
