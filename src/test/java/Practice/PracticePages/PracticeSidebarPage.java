package Practice.PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeSidebarPage {
    //4. U svakoj page klasi moram da ponovo deklarisem driver i da kreiram konstruktor
    public WebDriver driver;
    public WebDriverWait wdwait;

    //5. Svaki webelement kreiram posebno
    WebElement homeButton;
    WebElement practiceButton;
    WebElement coursesButton;
    WebElement blogButton;
    WebElement contactButton;
    //6. Nakon toga kreiram getter za svaki webelement

    public PracticeSidebarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    //7. Za return ubacujem lokator elementa da kada pozovem tu metodu zapravo dohvatim taj webelement
    public WebElement getHomeButton() {
        return driver.findElement(By.linkText("Home"));
    }

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    public WebElement getCoursesButton() {
        return driver.findElement(By.linkText("Courses"));
    }

    public WebElement getBlogButton() {
        return driver.findElement(By.linkText("Blog"));
    }

    public WebElement getContactButton() {
        return driver.findElement(By.linkText("Contact"));
    }

    //------------------------------------

    //8. Odvojim vizuelno u klasi delove gde trazim webelemente i gde kreiram akcije nad tim elementima

    //9. Zavisno sta mi treba od akcija kreiram metode
    //napomena: ne moraju sve metode da budu void, moze nam zatrebati akcija gde npr. izvlacimo text iz nekog elementa

    public void clickOnHomeButton() {
        getHomeButton().click();
    }

    public void clickOnPracticeButton() {
        getPracticeButton().click();
    }

    public void clickOnCoursesButton() {
        getCoursesButton().click();
    }

    public void clickOnBlogButton() {
        getBlogButton().click();
    }

    public void clickOnContactButton() {
        getContactButton().click();
    }

    //Isto radim za svaku page klasu
    //PracticePracticePage, PracticeLoginPage, PracticeProfilePage
    //-> nakon toga vratiti se na PracticeBaseTest klasu

}
