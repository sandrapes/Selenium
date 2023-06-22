package herkouapp_basic_auth_login_test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class Incorrect_username {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        String username = "admi";
        String password = "admin";

        String url = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(url);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);

        ArrayList<WebElement> listOfElements = new ArrayList<>(driver.findElements(By.id("content")));
        Assert.assertTrue(listOfElements.size() == 0);


    }
}
