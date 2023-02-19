package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

//    Test #1: Visits the admin cities page and list cities
//    Podaci:
//    admin email: admin@admin.com
//    admin password: 12345
//    Koraci:
//    Klik na sign up dugme iz navigacije
//    Prijaviti se na sistem admin kredencijalima
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    Verifikovati da se u url-u stranice javlja /admin/cities ruta

    @Test(priority = 10)
    @Description("Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities () {
        navPage.getSignupButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "Url does not contains '/admin/cities'");
    }

//    Test #2: Checks input types for create/edit new city
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    Kliknuti na New Item dugme
//    Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//    Verifikovati da polje za unos grada za atribut type ima tekst text

    @Test(priority = 20)
    @Description("Checks input types for create/edit new city")
    public void checksInputTypesForCreateOrEditNewCity () {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogBeVisible();
        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"), "text", "New item is a wrong type");
    }

//    Test #3: Create new city
//    Podaci:
//    city: [Ime i prezime polaznika]’s city
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    Kliknuti na New Item dugme
//    Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//    Uneti ime grada u polje
//    Kliknuti na Save dugme
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 30)
    @Description("Create new city")
    public void createNewCity () {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogBeVisible();
        citiesPage.getNewItemInput().sendKeys("Nis");
        citiesPage.getSaveButton().click();
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().contains("Saved successfully"), "Pop Up message does not contains 'Saved successfully'");
    }

//    Test #4: Edit city
//    Podaci:
//    old city name: [Ime i prezime polaznika]’s city
//    new city name: [Ime i prezime polaznika]’s city Edited
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    U polje za pretragu uneti staro ime grada
//    Sacekati da broj redova u tabeli bude 1
//    Kliknuti na dugme Edit iz prvog reda
//    Uneti novo ime za grad
//    Kliknuti na dugme Save
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 40)
    @Description("Edit city")
    public void editCity () {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Stefanija Spasic's city");
        citiesPage.waitForNumberOfRows(1);
        citiesPage.getEditButtonFromTable(1).click();
        citiesPage.getNewItemInput().click();
        citiesPage.getNewItemInput().sendKeys(Keys.COMMAND + "a");
        citiesPage.getNewItemInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNewItemInput().sendKeys("Stefanija Spasic's city Edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().contains("Saved successfully"), "Pop up message does not contains 'Saved successfully'");
    }

//    Test #5: Search city
//    Podaci:
//    city name: [Ime i prezime polaznika]’s city Edited
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    U polje za pretragu uneti staro ime grada
//    Sacekati da broj redova u tabeli bude 1
//    Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

    @Test(priority = 50)
    @Description("Search city")
    public void searchCity () {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Stefanija Spasic's city Edited");
        citiesPage.waitForNumberOfRows(1);
        Assert.assertTrue(citiesPage.getCellFromTable(1, 1).equals("Stefanija Spasic's city Edited"), "City with that name is wrong");
    }

//    Test #6: Delete city
//    Podaci:
//    city name: [Ime i prezime polaznika]’s city Edited
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    U polje za pretragu uneti staro ime grada
//    Sacekati da broj redova u tabeli bude 1
//    Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//    Kliknuti na dugme Delete iz prvog reda
//    Sacekati da se dijalog za brisanje pojavi
//    Kliknuti na dugme Delete iz dijaloga
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da poruka sadrzi tekst Deleted successfully

    @Test(priority = 60)
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Stefanija Spasic's city Edited");
        citiesPage.waitForNumberOfRows(1);
        Assert.assertEquals(citiesPage.getCellFromTable(1, 1), "Stefanija Spasic's city Edited", "City with that name is wrong");
        citiesPage.getDeleteButtonFromTable(1).click();
        citiesPage.waitForDeleteDialogBeVisible();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getPopUpMessage().getText().contains("Deleted successfully"), "The message does not contain 'Deleted successfully'");
    }

}
