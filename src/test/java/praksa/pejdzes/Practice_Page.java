package praksa.pejdzes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice_Page {

    public WebDriver driver;

    WebElement testLogInPageButton;
    WebElement testExceptionsButton;

    public Practice_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTestLogInPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public WebElement getTestExceptionsButton() {
        return driver.findElement(By.linkText("Test Exceptions"));
    }

    //--------------------------------


     public void clickOnTestLoginPage() {
        getTestLogInPageButton().click();
     }

     public void clickOnTestExceptionsbutton() {
        getTestExceptionsButton().click();
     }
}
