package herkouappExcellSheet.TestsHerkouapp;

import herkouappExcellSheet.BaseHerkouapp.BaseHerkouapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Testing extends BaseHerkouapp {

    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;

    String expectedURL;
    String website;


    @BeforeMethod
    public void pageSetUp() {

        driver.manage().window().maximize();
        website = excelReader.getStringData("URL", 0, 1);
        driver.get(website);

        validUsername = excelReader.getStringData("Login", 1, 0);
        invalidUsername = excelReader.getStringData("Login", 1, 2);
        validPassword = excelReader.getStringData("Login", 1, 1);
        invalidPassword = excelReader.getStringData("Login", 1, 3);
        expectedURL = excelReader.getStringData("URL", 1, 1);

    }

    @Test(priority = 10)
    public void userCanLogInWithValidUsernameAndValidPassword() {
        String logInLink = "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(logInLink);

        String expectedConfirmation = excelReader.getStringData("Assert", 0, 1);
        Assert.assertEquals(profilePage.getConfirmation().getText(), expectedConfirmation);
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
