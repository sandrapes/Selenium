package sauceDemo.SauceDemoTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sauceDemo.SauceDemoBase.SauceDemoBase;

public class LoginTest extends SauceDemoBase {

    String validUsername;
    String validPassword;
    String homeURL;
    String homepageURL;
    String cartText;
    String itemInCart;
    String textOnHomepage;

    @BeforeMethod
    public void pageSetUp() {
       driver.manage().window().maximize();

       homeURL = excelReader.getStringData("URL", 1, 1);
        validUsername = excelReader.getStringData("Login Credentials", 1, 0);
        validPassword = excelReader.getStringData("Login Credentials", 1, 1);
        homepageURL = excelReader.getStringData("URL", 2, 1);
        cartText = excelReader.getStringData("Cart", 1, 0);
        itemInCart = excelReader.getStringData("Products", 1, 0);
        textOnHomepage = excelReader.getStringData("Products", 0, 0);

        driver.get(homeURL);
    }

    public void logIn() {
        logInPage.insertUsername(validUsername);
        logInPage.insertPassword(validPassword);
        logInPage.clickOnLoginButton();
    }

    @Test
    public void userCanLogInWithValidUsernameAndValidPassword() {
        logIn();
        homePage.clickOnHamburgerMenu();
        Assert.assertEquals(homePage.getTitle().getText(), textOnHomepage);
        Assert.assertTrue(hamburgerMenu.getLogOutButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);

    }

    @Test
    public void userCanAddBackpackToCart() throws InterruptedException {
        logIn();
        homePage.clickOnHamburgerMenu();
        Assert.assertEquals(homePage.getTitle().getText(), textOnHomepage);
        Assert.assertTrue(hamburgerMenu.getLogOutButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);

        Thread.sleep(2000);
       // wait.until(ExpectedConditions.elementToBeClickable())
        homePage.clickOnAddToCartButtonSauceLabsBackpack();
        homePage.clickOnCartMenu();
        Assert.assertEquals(cartButton.getYourCartText().getText(), cartText);
        Assert.assertEquals(cartButton.getItemInCart().getText(), itemInCart);

    }



}
