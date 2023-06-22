package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Amazon_kolacici_prekoNiza {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartBeforeAdding.getText(), "0");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterAdding.getText(), "1");

        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        WebElement message = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertEquals(message.getText(), "Your Amazon Cart is empty");

        WebElement cartAfterRemovingItem = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterRemovingItem.getText(), "0");
        }
    }
