package herkouapp.base;

import herkouapp.pages.ProfilePage;
import herkouapp.pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    //Prethodni Domaci 1 (Sa Herokuapp) odraditi log-in koristeci POM (bez Excel file)

    public WebDriver driver;
    public WebDriverWait wait;

    public SidebarPage sidebarPage;
    public ProfilePage profilePage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sidebarPage = new SidebarPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
