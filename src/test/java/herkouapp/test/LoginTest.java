package herkouapp.test;

import herkouapp.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LoginTest extends BaseTest {

    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;
    String expectedURL;


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        validUsername = "admin";
        invalidUsername = "adminnn";
        validPassword = "admin";
        invalidPassword = "hbfhsdck";
        expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

    }
    @Test (priority = 10)
    public void userCanLogInWithValidUsernameAndValidPassword() {
        String logInLink = "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        Assert.assertEquals(profilePage.getConfirmation().getText(), "Congratulations! You must have the proper credentials.");
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test (priority = 20)
    public void userCannotlogInWithInvalidPasswordAndInvalidUsername() {
        String logInLink = "https://" + invalidUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);

        ArrayList<WebElement> listOfElements = new ArrayList<>(driver.findElements(By.id("content")));
        Assert.assertTrue(listOfElements.size() == 0);
    }

    @Test (priority = 30)
    public void userCannotlogInWithInvalidPasswordAndValidUsername() {
        String logInLink = "https://" + validUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);

        ArrayList<WebElement> listOfElements = new ArrayList<>(driver.findElements(By.id("content")));
        Assert.assertTrue(listOfElements.size() == 0);
    }

    @Test (priority = 40)
    public void userCannotlogInWithValidPasswordAndInvalidUsername() {
        String logInLink = "https://" + invalidUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);

        ArrayList<WebElement> listOfElements = new ArrayList<>(driver.findElements(By.id("content")));
        Assert.assertTrue(listOfElements.size() == 0);
    }

    @Test (priority = 50)
    public void userCannotlogInWithEmptyPasswordAndEmptyUsername() {
        String logInLink = "https://" + "" + ":" + "" + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);

        ArrayList<WebElement> listOfElements = new ArrayList<>(driver.findElements(By.id("content")));
        Assert.assertTrue(listOfElements.size() == 0);
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }


}
