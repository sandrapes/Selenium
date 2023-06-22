package sauceDemo.SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

   public WebDriver driver;

   WebElement usernameField;
   WebElement passwordField;
   WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    //--------------------------------------------------

    public void insertUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }


}
