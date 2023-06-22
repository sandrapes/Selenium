package herkouappExcellSheet.BaseHerkouapp;

import herkouapp.pages.ProfilePage;
import herkouapp.pages.SidebarPage;
import herkouappExcellSheet.PagesHerkouapp.ProfilePageHerkouapp;
import herkouappExcellSheet.PagesHerkouapp.SidebarPageHerkouapp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sauceDemo.SauceDemoBase.ExcelReader;

import java.io.IOException;
import java.time.Duration;

public class BaseHerkouapp {

    public WebDriver driver;
    public WebDriverWait wait;

    public SidebarPageHerkouapp sidebarPage;
    public ProfilePageHerkouapp profilePage;

    public ExcelReader excelReader;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sidebarPage = new SidebarPageHerkouapp(driver);
        profilePage = new ProfilePageHerkouapp(driver);

        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\Herkouapp.xlsx");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
