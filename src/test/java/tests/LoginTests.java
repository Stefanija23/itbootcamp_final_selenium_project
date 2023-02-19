package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
//    Test #1: Visits the login page
//    Koraci:
//    Postaviti EN jezik stranice
//    Klik na login dugme iz navigacije
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 10)
    @Description("Visits the login page")
    public void visitsTheLoginPage () {
        navPage.getLanguageButton().click();
        navPage.getEnglishButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login' ");
    }

//    Test #2: Checks input types
//    Koraci:
//    Klik na login dugme iz navigacije
//    Verifikovati da polje za unos emaila za atribut type ima vrednost email
//    Verifikovati da polje za unos lozinke za atribut type ima vrednost password

    @Test(priority = 20)
    @Description("Checks input types")
    public void checksInputTypes () {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email", "Email attribute is wrong.");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password", "Password attribute is wrong.");
    }

//    Test #3: Displays errors when user does not exist
//    Podaci:
//    email: non-existing-user@gmal.com
//    password: password123
//    Koraci:
//    Klik na login dugme iz navigacije
//    Popuniti login formu podacima za logovanje
//    Klik na login dugme
//    Sacekati da popu za prikaz greske bude vidljiv
//    Verifikovati da greska sadrzi poruku User does not exists
//    Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 30)
    @Description("Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist () {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitVerifyMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.getPopUpMessage(), "User does not exist", "PopUp Message does not contain 'User does not exist");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login'");
    }

//    Test #4: Displays errors when password is wrong
//    Podaci:
//    email: admin@admin.com
//    password: password123
//    Koraci:
//    Klik na login dugme iz navigacije
//    Popuniti login formu podacima za logovanje
//    Klik na login dugme
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da greska sadrzi poruku Wrong password
//    Verifikovati da se u url-u stranice javlja /login ruta

    @Test(priority = 40)
    @Description("Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong () {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitVerifyMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.getPopUpMessage(), "Wrong password", "Message does not contain 'Wrong password'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login'");
    }

//    Test #5: Login
//    Podaci:
//    email: admin@admin.com
//    password: 12345
//    Koraci:
//    Klik na login dugme iz navigacije
//    Popuniti login formu podacima za logovanje
//    Verifikovati da se u url-u stranice javlja /home ruta

    @Test(priority = 50)
    @Description("Login")
    public void login () {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login'");
    }

//    Test #6: Logout
//    Koraci:
//    Verifikovati da je dugme logout vidljivo na stranici
//    Kliknuti na logout dugme

    @Test(priority = 60)
    @Description("Logout")
    public void logout () {
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Logout button is not displayed.");
        navPage.getLogoutButton().click();
    }
}
