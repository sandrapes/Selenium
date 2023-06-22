package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        //Potrebno je preko Gugla naci stranicu Wikipedije o Nikoli Tesli na cirilici

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


        //Kreiram string jer ce mi naziv biti potreban kasnije za proveru
        //Ovaj string moze da se doda naknadno
        String ime = "Никола Тесла";
        //Nalazim element preko lokatora "name" jer mi deluje najpouzdanije
        //Postoji i element preko lokatora ID, ali njegova vrednost ne izgleda pouzdano (vrednost: APjFqb) - vrednost je mozda kreirana nekim nasumicnim kodom
        WebElement googleSearchBar = driver.findElement(By.name("q"));
        googleSearchBar.sendKeys(ime);

        //Nalazim element preko lokatora "name" jer je po hijerarhiji najpouzdaniji
        WebElement googleSearchButton = driver.findElement(By.name("btnK"));
        Thread.sleep(2000);
        //Ako ne stavim cekanje test ce pasti jer dugme nije klikabilno JOS UVEK
        //Jos uvek nije jer je program prebrzo ukucao pretragu i potrazio element, a html nije odreagovao na nasu akciju unosa
        googleSearchButton.click();

        //Napomena: Ako element ne moze da se pronadje ili pokazuje bilo kakvu gresku, prvo dodajemo thread sleep pre nase akcije
        //da utvrdimo da li je problem do cekanja na element ili na sam lokator elementa
        //Ako i posle cekanja i dalje imamo problem sa elementom, onda nam je problem do lokatora

        //WebElement wikipedia = driver.findElement(By.className("LC20lb MBeuO DKV0Md"));
        //Nasli smo element koji ima klasu, ali ta klasa ima tri vrednosti "LC20lb MBeuO DKV0Md"
        //U tom slucaju prebacujemo sa By.className u By.cssSelector
        //Umesto razmaka izmedju vrednosti stavljamo tacku "."
        //I tacku stavljamo na pocetak vrednosti
        WebElement wikipedia = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipedia.click();

        //Testiram da li je URL adekvatan
        //Prvo trazim vrednost - actual
        //Zatim prosledjujem sta ocekujem - expected
        Assert.assertEquals(driver.getCurrentUrl(), "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0");

        //Testiram da li title uopste postoji
        WebElement title = driver.findElement(By.className("mw-page-title-main"));
        //Kada proveravam da li nesto postoji vrednost mora biti TRUE
        //Na element dodajemo .isDisplayed() da bi nam vrednost bila TRUE ili FALSE
        Assert.assertTrue(title.isDisplayed());

        //Testiram vrednost elementa title tako sto prvo uzimam string elementa kroz metodu .getText()
        //I uporedjujem taj string sa ocekivanim
        Assert.assertEquals(title.getText(), ime);

        //Testiram da li je slika prisutna
        WebElement image = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(image.isDisplayed());

        //-------------------------
        //Assert.assertTrue(Prosledjujemo boolean vrednost koja mora biti true);
        //Ako nije true onda ce test da padne
        //Prosledjena vrednost mora biti TRUE ili FALSE
        //Ne mozemo proslediti string, broj, objekat, webelement...
        //Vrednost koju cemo najcesce koristiti da ima vrednost TRUE ili FALSE ce biti nalazenje elementa -> element.isDisplayed()

        //Assert.assertEquals(Prosledjujem vrednost koja je nadjena, Prosledjujem vrednost koju ocekujem);
        //Assert.assertEquals(Actual value, Expected value);

        //Testiram da li je title jednak ocekivanom

        /*WebElement title = driver.findElement(By.className("mw-page-title-main"));
        String actualTitle = title.getText();
        Assert.assertEquals(actualTitle, ime);*/


    }
}
