package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

//    Test #1: Set locale to ES
//    Koraci:
//    Postaviti jezik na ES
//    Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

    @Test(priority = 10)
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getSpanishButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Página de aterrizaje"), "Header does not contain text 'Página de aterrizaje'");
    }

//    Test #2: Set locale to EN
//    Koraci:
//    Postaviti jezik na EN
//    Verifikovati da se na stranici u hederu javlja tekst Landing

    @Test(priority = 20)
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnglishButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Landing"), "Header does not contain text 'Landing' ");
    }

//    Test #3: Set locale to CN
//    Koraci:
//    Postaviti jezik na CN
//    Verifikovati da se na stranici u hederu javlja tekst 首页

    @Test(priority = 30)
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getChineseButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("首页"), "Header does not contain text '首页' ");
    }

//    Test #4: Set locale to FR
//    Koraci:
//    Postaviti jezik na FR
//    Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage

    @Test(priority = 40)
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrenchButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Page d'atterrissage"), "Header does not contain text 'Page d'atterrissage' ");
    }
}

