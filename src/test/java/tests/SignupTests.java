package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
//    Test #1: Visits the signup page
//    Koraci:
//    Klik na sign up dugme iz navigacije
//    Verifikovati da se u url-u stranice javlja /signup ruta

    @Test(priority = 10)
    @Description("Visits the signup page")
    public void visitsTheignupPage () {
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain '/signup'");
    }

//    Test #2: Checks input types
//    Koraci:
//    Klik na sign up dugme iz navigacije
//    Verifikovati da polje za unos emaila za atribut type ima vrednost email
//    Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//    Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

    @Test(priority = 20)
    @Description("Checks input types")
    public void checksInputTypes () {
        navPage.getSignupButton().click();
        Assert.assertTrue(signupPage.getEmailInput().getAttribute("type").equals("email"), "Email type is wrong");
        Assert.assertTrue(signupPage.getPasswordInput().getAttribute("type").equals("password"), "Password type is wrong");
        Assert.assertTrue(signupPage.getConfirmPasswordInput().getAttribute("type").equals("password"), "Confirm password type is wrong");
    }

//    Test #3: Displays errors when user already exists
//    Podaci:
//    name: Another User
//    email: admin@admin.com
//    password: 12345
//    confirm password: 12345
//    Koraci:
//    Klik na sign up dugme iz navigacije
//    Verifikovati da se u url-u stranice javlja /signup ruta
//    Popuniti formu za registraciju podacima
//    Klik na sign up dugme
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da greska sadrzi poruku E-mail already exists
//    Verifikovati da se u url-u stranice javlja /signup ruta

    @Test(priority = 30)
    @Description("Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExists () {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain '/signup'");
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getPopUpMessage().getText(), "Email already exists.", "In pop up message is not 'E-mail already exists'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain '/signup'");
    }

//    Test #4: Signup
//    Podaci:
//    name: Ime i prezime polaznika
//    email template: ime.prezime@itbootcamp.rs
//    password: 12345
//    confirm password: 12345
//    Koraci:
//    Klik na sign up dugme iz navigacije
//    Popuniti formu podacima za registraciju
//    Klik na sign up dugme
//    Ucitati stranicu /home
//    Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//    Kliknuti na Close dugme iz dijaloga
//    Kliknuti na logout

    @Test(priority = 40)
    @Description("Signup")
    public void signup () {
        navPage.getSignupButton().click();
        signupPage.getNameInput().sendKeys("Stefanija Spasic");
        signupPage.getEmailInput().sendKeys("stefanija.spasic@itbootcamp.rs");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        messagePopUpPage.waitVerifyMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.getPopUpMessage().getText(), "Verify your account", "There is not message 'Verify your account'");
        messagePopUpPage.getCloseButtonFromVerifyAccount().click();
        navPage.getLogoutButton().click();
    }
}
