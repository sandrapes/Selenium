package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_04_Waiteri {

    public static void main(String[] args) throws InterruptedException {

        //Otici na google, sacekati 3 sekunde, odraditi refresh, uneti u polje pretrage "youtube", sacekati 2 sekunde,
        // preko ENTER dugmeta odraditi pretragu. Sacekati jos 5 sekundi i zatvorite driver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        Thread.sleep(3000);

        driver.navigate().refresh();

        WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        searchbox.sendKeys("youtube");

        Thread.sleep(2000);

        searchbox.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.quit();

    }
}
