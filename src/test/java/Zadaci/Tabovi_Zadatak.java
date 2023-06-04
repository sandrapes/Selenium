package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Tabovi_Zadatak {

    public static void main(String[] args) {

        //Zadatak 2
        //Otvoriti browser i jos 5 tabova
        //Na svakom tabu otvoriti URL po zelji
        //Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.open()");
        }

        //js.executeScript("window.open()");
        //js.executeScript("window.open()");
        //js.executeScript("window.open()");
        //js.executeScript("window.open()");
        //js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        //driver.getCurrentUrl(); da dohvati url tog elementa

        driver.navigate().to("https://google.com/"); // postavio je sajt na originalni tab (0)

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://joberty.rs/");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.facebook.com/");

        driver.switchTo().window(listaTabova.get(4));
        driver.navigate().to("https://www.instagram.com/");

        driver.switchTo().window(listaTabova.get(5));
        driver.navigate().to("https://www.instagram.com/");

        for (int i = 0; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }

            }

        }

    }

