package Practice.PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeLoginPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement notification;

    public PracticeLoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getNotification() {
        return driver.findElement(By.className("show"));
    }

    //-------------------------------

    public void insertUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

}
