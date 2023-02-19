package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

//    Test #1: Forbids visits to home url if not authenticated
//    Koraci:
//    Ucitati /home stranu
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login' ");
    }

//    Test #2: Forbids visits to profile url if not authenticated
//    Koraci:
//    Ucitati /profile stranu
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login' ");
    }

//    Test #3: Forbids visits to admin cities url if not authenticated
//    Koraci:
//    Ucitati /admin/cities stranu
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login' ");
    }

//    Test #4: Forbids visits to admin users url if not authenticated
//    Koraci:
//    Ucitati /admin/users stranu
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain '/login' ");
    }
}