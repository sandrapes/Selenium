package negative_test_cases_login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Both_incorrect {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a"));
        loginButton.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("students");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password1234");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Your username is invalid!";
        WebElement title = driver.findElement(By.id("error"));
        String actualTitle = title.getText();
        Assert.assertEquals(actualTitle, expectedTitle);

        Assert.assertTrue(submitButton.isDisplayed());
    }
}
