package sauceDemo.SauceDemoBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sauceDemo.SauceDemoPages.CartButton;
import sauceDemo.SauceDemoPages.HamburgerMenu;
import sauceDemo.SauceDemoPages.HomePage;
import sauceDemo.SauceDemoPages.LogInPage;

import java.io.IOException;
import java.time.Duration;

public class SauceDemoBase {

    public WebDriver driver;
    public WebDriverWait wait;
    //ovde dodajemo excel reader
    public ExcelReader excelReader;

    public LogInPage logInPage;
    public HomePage homePage;
    public HamburgerMenu hamburgerMenu;
    public CartButton cartButton;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.logInPage = new LogInPage(driver);
        this.homePage = new HomePage(driver);
        this.hamburgerMenu = new HamburgerMenu(driver);
        this.cartButton = new CartButton(driver);

        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\TestData.xlsx");
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();

    }


}
