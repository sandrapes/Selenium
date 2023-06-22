package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WordpressHappyFlow {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/");


        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();


        Thread.sleep(2000);
        String validUsername = "sandrapes";
        WebElement logInEmail = driver.findElement(By.id("usernameOrEmail"));
        logInEmail.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        Thread.sleep(5000);
        String validPass = "nekirendompass1256";
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(validPass);

        Thread.sleep(5000);
        WebElement login = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        login.click();

        Thread.sleep(5000);
        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertTrue(profileButton.isDisplayed());

        profileButton.click();

        Thread.sleep(2000);

        //wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Gravatar profile"))));
        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        Assert.assertEquals(profileName.getText(), validUsername);

        WebElement logOutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logOutButton.isDisplayed());


    }
}
