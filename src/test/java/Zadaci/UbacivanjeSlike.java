package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UbacivanjeSlike {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://crop-circle.imageonline.co/#circlecropresult");

        String imageLocation = "C:\\Users\\Korisnik\\Desktop\\slika.avif";
        WebElement uploadImg = driver.findElement(By.id("inputImage"));

        uploadImg.sendKeys(imageLocation);


    }
}
