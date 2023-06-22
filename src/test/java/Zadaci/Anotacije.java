package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Anotacije {

    WebDriver driver; //Deklaracija - kreiranje objekta
    //Deklaraciju drivera moram da obavim van svih metoda jer na taj nacin je driver vidljiv u svim metodama
    //Kada bih driver deklarisao u jednoj metodi, on bi bio vidljiv samo u njoj
    WebDriverWait wait;
    String validUsername;
    String invalidUsername;
    String validPassword;
    String invalidPassword;

    @BeforeClass
    public void setUp() {
        //Resio sam u BeforeClass da stavim samo setup drivera
        //Mogao sam ovde da inicijalizujem driver ali onda bi svi testovi bili odradjeni u jednom browseru
        WebDriverManager.chromedriver().setup();
        validUsername = "student";
        invalidUsername = "123";
        validPassword = "Password123";
        invalidPassword = "password123";
    }

    @BeforeMethod
    public void beforeEveryTest() {
        driver = new ChromeDriver(); //Inicijalizacija - dodeljivanje vrednosti objekta
        //Zato sto sam driver inicijalizovao u BeforeMethod zato svaki test se pokrece u novom browseru
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    //Pravim pomocnu metodu koju cu da pozivam kako bih dosao do odredjene stranice
    //Na ovaj nacin mi se code ne duplira
    public void goToLoginPage() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
    }

    //Kao i za prethodnu metodu, pravim za akciju logovanja kako ne bih ponavljao taj blok
    public void logIn() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        //Pozivam pomocne metode
        //Isto bi bilo kada bih sadrzaj tih metoda ubacio umesto naredne linije
        goToLoginPage();
        logIn();
        WebElement title = driver.findElement(By.className("post-title"));
        Assert.assertEquals(title.getText(), "Logged In Successfully");
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test
    public void userCanLogOut() {
        goToLoginPage();
        //logIn();
        //Mogao sam da ubacim metodu logovanja ali zelim da ipak imam asertaciju da sam zapravo ulogovan
        //kako bih znao da sam izlogovan
        //u suprotnom moze se desiti da se zapravo i ne izlogujem, da se ne odradi klik na log out (a akcija klika se odradi ako se zadesi takav lokator na stranici bez naseg znanja)
        //u smislu da mozda zapravo postoji negde link text "Log out" i da nije vidljiv, nas driver ce uspeti da odradi klik
        //i nakon toga proveravamo samo URL koji ce biti ispravan jer se nismo zapravo ni ulogovali
        //iz tog razloga su mi potrebne asertacije iz prethodnog testa da se uverim za izlogovanje da MORAM biti ulogovan
        userCanLogIn();
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        //Ako zelimo da proverimo da li neki element NIJE prisutan - ne mozemo samo pisati Assert.assertFalse(logOutButton);
        //jer nas program ako ne pronadje element, nece vratiti "false" nego null vrednost
        //zato moramo da primenimo naredni blok

        //kreiram boolean koji ce imati vrednost false
        //i za slucaj da se element (koji zelim da proverim da ne postoji) pojavi, onda ce se vrednost boolean
        //promeniti na true
        boolean logOut = false;
        try {
            //u ovom delu kazemo:
            //Ako pronadjes element dodeli mu vrednost true i tu vrednost prebaci na boolean
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {
            //Ovaj deo bloka moze da ostane prazan, a za argument je potrebno da prosledimo samo neki Exception
        }
        //Na kraju proveravamo da li je boolean ostao false
        //Ostace false samo kada se element ne pronadje
        //Ako se pronadje onda menja vrednost u true i nas test pada
        Assert.assertFalse(logOut);

        //Na kraju ovakvog testa treba da proverimo ispravnost koda tako sto napravimo situaciju da element
        //bude zapravo prisutan (u ovom slucaju ne izlogujemo se) i tada test treba da padne
        //onda smo sigurni da smo dobar test napravili i vratimo test u prethodno stanje kada je prolazio
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        goToLoginPage();
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!");
    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        goToLoginPage();
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(invalidPassword);
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!");
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
