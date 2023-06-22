package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mim {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");


        WebElement uploadNewTemp = driver.findElement(By.id("mm-show-upload"));
        uploadNewTemp.click();
        String imageLocation = "C:\\Users\\Korisnik\\Desktop\\551od3.jpg";

        //WebElement fromComp = driver.findElement(By.id("mm-upload-file-btn"));
        //fromComp.click();
       // fromComp.sendKeys(imageLocation);



    }
}
