package praksa.baza;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import praksa.pejdzes.LoggedInPage;
import praksa.pejdzes.Practice_Page;
import praksa.pejdzes.Sidebar_Page;
import praksa.pejdzes.TestLoginPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class Base_Test {

    public WebDriver driver;
    public WebDriverWait wait;

    public Sidebar_Page sidebarPage;
    public Practice_Page practicePage;
    public TestLoginPage testLoginPage;
    public LoggedInPage loggedInPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // dodajemo klasu koju smo kreirali da kasnije iz neke druge klase mozemo da je dohvatimo
        sidebarPage = new Sidebar_Page(driver);
        practicePage = new Practice_Page(driver);
        testLoginPage = new TestLoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement e) {
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForClickability(WebElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void clickElement(WebElement e) {
        e.click();
    }

    public boolean elementIsPresent(WebElement element) {
        boolean someElement = false;
        try {
            someElement = element.isDisplayed();
        } catch (Exception e) {

        }
        return someElement;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

   public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\Korisnik\\Desktop\\";
        ImageIO.write(saveImage, "png", new File(location + System.currentTimeMillis() + ".png"));
    }


    @AfterClass
    public void tearDown() {
       driver.quit();
    }


}
