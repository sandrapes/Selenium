package praksa.pejdzes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {

    public WebDriver driver;

    WebElement logOutButton;
    WebElement title;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.linkText("Log out"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("post-title"));
    }

    //-----------------------

    public String checkText() {
        return getTitle().getText();
    }

}
