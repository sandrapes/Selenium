package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {


        //System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe"); --deprecated
        //Pre je chromedriver morao da se downloaduje na racunar i da se pozove kako bi se radilo sa njim
        //Onda se prosledi putanja u property kako bismo mogli da kreiramo objekat

        WebDriverManager.chromedriver().setup(); //Setujemo chromedriver
        //Ili bilo koji drugi driver koji podrzava biblioteka --> io.github.bonigarcia.wdm.WebDriverManager;
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();
        //WebDriverManager.edgedriver().setup();

        WebDriver driver = new ChromeDriver();
        //Kreiramo objekat web drivera kako bismo mogli da pozovemo metode iz klase WebDriver
        driver.manage().window().maximize();
        //Dajemo prvo komandu da se prozor poveca
        driver.get("https://www.google.com");
        //Odlazimo na link
        //Napomena: Link ne moze da krene sa "www" jer onda driver nece moci da otvori stranicu
        System.out.println(driver.getCurrentUrl());
        //Stampamo URL na kojoj stranici se trenutno nalazimo
        driver.navigate().to("https://www.youtube.com");
        //Koristimo drugu metodu kojom mozemo da odemo na zeljeni link
        driver.navigate().refresh();
        //Dajemo komandu za refresh
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        //Komanda za korak nazad
        driver.navigate().forward();
        //Komanda za korak napred
        driver.quit();
        //Gasimo driver i browser
        //Napomena: Poslednji korak se uvek zakomentarise DOK pravite test
        //Kako biste mogli da vidite jel ste dobili zeljeno stanje morate da vidite aplikaciju
        //Tek kada ste utvrdili da je test ispravan onda dodajete driver.quit()

    }


}
