package Practice.PracticePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePracticePage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement testLoginPageButton;
    WebElement testExceptionsButton;

    public PracticePracticePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTestLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public WebElement getTestExceptionsButton() {
        return driver.findElement(By.linkText("Test Exceptions"));
    }

    //---------------------------------

    public void clickOnTestLoginPageButton() {
        getTestLoginPageButton().click();
    }

    public void clickOnTestExceptionsButton() {
        getTestExceptionsButton().click();
    }

}
