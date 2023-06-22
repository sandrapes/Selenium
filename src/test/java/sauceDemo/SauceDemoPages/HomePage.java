package sauceDemo.SauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public WebDriver driver;

    WebElement title;
    WebElement hamburgerMenu;
    WebElement addToCartButtonBackpack;
    WebElement cartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("product_label"));
    }

    public WebElement getHamburgerMenu() {
        return driver.findElement(By.className("bm-burger-button"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.cssSelector(".svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x."));
    }

    public WebElement getAddToCartButtonBackpack() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn_primary.btn_inventory"));
        return elements.get(4);
    }



    //----------------------------------------------

    public void clickOnHamburgerMenu() {
        getHamburgerMenu().click();
    }

    public void clickOnCartMenu() {
        getCartButton().click();
    }

    public void clickOnAddToCartButtonSauceLabsBackpack() {
        getAddToCartButtonBackpack().click();

    }





}
