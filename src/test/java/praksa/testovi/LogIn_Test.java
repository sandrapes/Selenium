package praksa.testovi;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import praksa.baza.Base_Test;

public class LogIn_Test extends Base_Test {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

    }

    @Test (priority = 10)
    public void userCanLogIn() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("student");
        testLoginPage.insertPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(loggedInPage.getLogOutButton().isDisplayed());
        Assert.assertEquals(loggedInPage.checkText(), "Logged In Successfully");

    }

    @Test (priority = 20)
    public void userCantLogInWithIncorrectUsername() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("skjhsbdj");
        testLoginPage.insertPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

    @Test (priority = 30)
    public void userCantLogInWithIncorrectPassword() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("student");
        testLoginPage.insertPassword("Password");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }


    @Test (priority = 40)
    public void userCantLogInWithIncorrectPasswordAndIncorrectUsername() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("student321");
        testLoginPage.insertPassword("Password");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test (priority = 50)
    public void userCantLogInWithNoUsernameAndNoPassword() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("");
        testLoginPage.insertPassword("");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test (priority = 60)
    public void userCantLogInWithUsernameWrittenInCapsLock() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("STUDENT");
        testLoginPage.insertPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test (priority = 70)
    public void userCantLogInWithPasswordWrittenInCapsLock() {
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("student");
        testLoginPage.insertPassword("PASSWORD123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }


    @Test (priority = 80)
    public void userCantLogInWithPasswordAndUsernameWrittenInCapsLock() {
        waitForClickability(sidebarPage.getPracticeButton());
        sidebarPage.clickOnPracticebutton();
        practicePage.clickOnTestLoginPage();
        testLoginPage.insertUsername("STUDENT");
        testLoginPage.insertPassword("PASSWORD123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(testLoginPage.textDisplayed(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }




}
