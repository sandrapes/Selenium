package sauceDemo.SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartButton {

    public WebDriver driver;

    WebElement yourCartText;
    WebElement itemInCart;


    public CartButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getYourCartText() {
        return driver.findElement(By.className("subheader"));
    }

    public WebElement getItemInCart() {
        return driver.findElement(By.className("inventory_item_name"));
    }




}
