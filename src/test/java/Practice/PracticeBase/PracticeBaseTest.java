package Practice.PracticeBase;

import Practice.PracticePages.PracticeLoginPage;
import Practice.PracticePages.PracticePracticePage;
import Practice.PracticePages.PracticeProfilePage;
import Practice.PracticePages.PracticeSidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class PracticeBaseTest {

    //BaseTest klasa mi sluzi da smestim sve pocetne i krajnje metode uz pomocne metode koje cu koristiti u
    //testovima. Npr. metoda za cekanje, metoda za scroll...
    //1. Inicijalizujem driver i wdwait na pocetku van svih metoda. Moraju biti public kako bih ih video
    //u test klasi
    public WebDriver driver;
    public WebDriverWait wdwait;

    //10. Svaku page stranicu moram da deklarisem van metoda
    public PracticeSidebarPage practiceSidebarPage;
    public PracticePracticePage practicePracticePage;
    public PracticeLoginPage practiceLoginPage;
    public PracticeProfilePage practiceProfilePage;

    //2. Kreiram metodu setUp sa anotacijom BeforeClass jer zelim da se izvrsi samo jednom na pocetku
    //U toj metodi cu da inicijalizujem driver i wdwait
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //11. Svaku page stranicu inicijalizujem u setUp metodi i prosledjujem driver i wdwait
        practiceSidebarPage = new PracticeSidebarPage(driver, wdwait);
        //-> preci na test klasu (LoginTest)
        practicePracticePage = new PracticePracticePage(driver, wdwait);
        practiceLoginPage = new PracticeLoginPage(driver, wdwait);
        practiceProfilePage = new PracticeProfilePage(driver, wdwait);

    }

    //3. Kreiram metodu tearDown sa anotacijom AfterClass jer zelim na samom kraju da mi se obavi neka akcija
    @AfterClass
    public void tearDown() {
        //driver.quit();
        //Dok pravim testove zakomentarisacu driver.quit() jer zelim da mi ostane otvoren prozor tokom testa
        //ako padne iz nekog razloga ili da proverim da li je sve kako treba
        //Tek kad zavrsim posao onda cu otvoriti driver.quit()
    }

    //Za svaku stranicu moram da kreiram posebnu klasu gde cu smestiti sve webelemente te stranice
    //Ako imam deo aplikacije koji se ponavlja na svakoj ili na vise razlicitih stranica
    //onda za taj deo cu napraviti posebnu klasu i to je prva klasa koju pravim nakon BaseTest
    //->pogledati klasu PracticeSidebarPage
}
