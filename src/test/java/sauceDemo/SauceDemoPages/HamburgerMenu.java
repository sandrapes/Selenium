package sauceDemo.SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HamburgerMenu  {

    public WebDriver driver;

    WebElement allItemsButton;
    WebElement aboutButton;
    WebElement logOutButton;
    WebElement resetAppStateButton;

    public HamburgerMenu(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAllItemsButton() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getAboutButton() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getResetAppStateButton() {
        return driver.findElement(By.id("reset_sidebar_link"));
    }


}
