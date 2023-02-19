package pages;
//dugme New Item
//input za pretragu
//metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//metodu koja ceka da se dijalog za brisanje pojavi
//save dugme iz dijalog za editovanje i kreiranje
//delete dugme iz dijaloga za brisanje
//metodu koja ceka da se u tabeli pojavi odredjeni broj redova. Metoda kao parametar prima broj redova.
//Ako se metoda pozove sa parametrom 5, to znaci da metoda ceka da se u tabeli pojavi 5 redova.
//metodu koja vraca celiju iz odredjenog reda. Metoda kao parametre prima red i kolonu a vraca td iz tabele.
//Npr: ukoliko se metoda pozove row=2, cell=3 tada metoda vraca trecu celiju iz 2 reda.
//metodu koja vraca edit dugme trazenog reda. Metoda kao parametar prima red a vraca dugme.
//Npr ako se metoda pozove row=3, metoda vraca edit dugme iz treceg reda tabele
//metodu koja vraca delete dugme trazenog reda. Metoda kao parametar prima red a vraca dugme.
//Npr ako se metoda pozove row=3, metoda vraca delete dugme iz treceg reda tabele


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public WebElement getNewItemButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary')]"));
    }
    public WebElement getSearchInput () {
        return driver.findElement(By.id("search"));
    }
    public WebElement getNewItemInput () {
        return driver.findElement(By.xpath("//input[@id = 'name']"));
    }
    public void waitForEditAndCreateDialogBeVisible () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog dlgNewEditItem v-dialog--active')]")));
    }
    public void waitForDeleteDialogBeVisible () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog v-dialog--active')]")));
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave v-btn v-btn--text theme--light v-size--default green--text text--lighten3')]"));
    }
    public WebElement getDeleteButton () {
        return driver.findElement(By.xpath("//*[text()=' Delete ']"));
    }
    public void waitForNumberOfRows (int rowNumber) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]/table/tbody"), rowNumber));
    }
    public WebElement getCellFromTable (int rowNumber, int cellNumber) {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]/table/tbody/tr["+rowNumber+"]/td["+cellNumber+"]"));
    }
    public WebElement getEditButtonFromTable (int rowNumber) {
        return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));
    }
    public WebElement getDeleteButtonFromTable(int rowNumber) {
        return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='delete']"));
    }

}
