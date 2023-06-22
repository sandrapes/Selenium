package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootcamp {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        element1.sendKeys("ITBootcamp");

        Thread.sleep(5000);

        element1.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        WebElement element3 = driver.findElement(By.xpath("/html/body/div[6]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3"));
        element3.click();

    }
}
