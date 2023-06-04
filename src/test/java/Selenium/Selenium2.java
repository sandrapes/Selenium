package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //ovde se otvara prvi tab, prazan, sve posle sto radis se gradi na ovome
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
       // System.out.println(listaTabova.get(0));
       // System.out.println(listaTabova.get(1));
       // System.out.println(listaTabova.get(2));
       // System.out.println(listaTabova.get(3));

        driver.switchTo().window(listaTabova.get(0));
        driver.navigate().to("https://google.com/");

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://joberty.rs/");

        driver.close(); //zatvara samo tab na kome se nalazi

        driver.switchTo().window(listaTabova.get(2));
        driver.close(); //zatvara tab koji prosledjujemo

        driver.quit(); // zatvara sve


    }
}
