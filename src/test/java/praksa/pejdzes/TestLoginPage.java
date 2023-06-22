package praksa.pejdzes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLoginPage {

    public WebDriver driver;

    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement text;

    public TestLoginPage(WebDriver driver) {
        this.driver = driver;
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

    public WebElement getText() {
        return driver.findElement(By.id("error"));
    }

    //---------------------------------------

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

    public String textDisplayed() {
        return getText().getText();
    }
}
