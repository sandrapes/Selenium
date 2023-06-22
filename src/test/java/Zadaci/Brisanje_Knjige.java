package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Brisanje_Knjige {

    public static void main(String[] args) {

        ////Zadatak 8
        ////https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        ////Potrebno je napraviti test dodavanja knjige u korpu
        ////i brisanjem samo jednog cookie-a treba da se obrise knjiga iz korpe

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        WebElement cart = driver.findElement(By.id("nav-cart-count-container"));
        cart.click();


        driver.manage().deleteCookieNamed("session-id");
        driver.navigate().refresh();

        WebElement emptyCart = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        String expectedTitle = "Your Amazon Cart is empty";
        Assert.assertEquals(emptyCart.getText(), expectedTitle);




    }
}
