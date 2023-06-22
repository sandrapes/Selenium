package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAutomationLogin_Anotacije {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        Thread.sleep(3000);
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogin = driver.findElement(By.linkText("Test Login Page"));
        testLogin.click();

    }

    @Test
    public void happyFlow() throws InterruptedException {

        String username = "student";
        String password = "Password123";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertEquals(logOutButton.getText(), "Log out");

        String expectedTitle = "Logged In Successfully";
        WebElement title = driver.findElement(By.className("post-title"));
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Test
    public void incorrectUsername() throws InterruptedException {

        String username = "studentt";
        String password = "Password123";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String expectedError = "Your username is invalid!";
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertEquals(errorMessage.getText(), expectedError);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);

    }

    @Test
    public void incorrectPassword() throws InterruptedException {

        String username = "student";
        String password = "Password1234";

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String expectedError = "Your password is invalid!";
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertEquals(errorMessage.getText(), expectedError);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);

    }



}
