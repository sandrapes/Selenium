package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.xpath("//*[@id=\"menu-item-20\"]/a"));
        practiceButton.click();

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        logInButton.click();

        String username = "student";
        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys(username);

        String pass = "Password123";
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys(pass);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedText = "Logged In Successfully";
        Assert.assertTrue(driver.findElement(By.className("post-title")).isDisplayed());

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertEquals(driver.findElement(By.className("post-title")).getText(), expectedText);


    }
}
