package DemoQA_bookstore_opet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AddingBooks {
    WebDriver driver;
    String validUsername;
    String validPassword;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        validUsername = "sandrapes";
        validPassword = "Nekirendompass1256!";

    }

    @BeforeMethod
    public void beforeEveryTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");
        js = (JavascriptExecutor) driver;
        Thread.sleep(3000);



    }


    public void logIn() {
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        WebElement login = driver.findElement(By.id("login"));
        login.click();

    }

    public void addBook1() throws InterruptedException {
        Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,350)", "");
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();

    }

    public void addBook2() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement addBook2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook2.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();

    }

    public void addBook3() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        book3.click();

        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement addBook3 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook3.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();

    }

    public void addBook4() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book4 = driver.findElement(By.linkText("Speaking JavaScript"));
        book4.click();

        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement addBook4 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook4.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();

    }

    @Test (priority = 10)
    public void addOneBook() throws InterruptedException {
        logIn();

        addBook1();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        goToProfile();

        Thread.sleep(2000);

        WebElement checkBook1 = driver.findElement(By.cssSelector(".rt-tr.-odd"));
        Assert.assertTrue(checkBook1.isDisplayed());


    }

    @Test (priority = 20)
    public void removePreviousAndAddTwoBooks() throws InterruptedException {
        logIn();
        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        goToProfile();
        Thread.sleep(3000);
        removeBook();
        boolean bookRemoved = false;
        try {
            bookRemoved = driver.findElement(By.linkText("Git Pocket Guide")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(bookRemoved);

       js.executeScript("window.scrollBy(0,350)", "");
       WebElement goToStoreButton = driver.findElement(By.id("gotoStore"));
       goToStoreButton.click();

       addBook1();
       addBook2();

        js.executeScript("window.scrollBy(0,350)", "");
        goToProfile();

        Thread.sleep(2000);

        WebElement checkBook1 = driver.findElement(By.cssSelector(".rt-tr.-odd"));
        Assert.assertTrue(checkBook1.isDisplayed());

        WebElement checkBook2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(checkBook2.isDisplayed());

    }

    @Test (priority = 30)
    public void removePreviousAndAddThreeBooks() throws InterruptedException {
        logIn();
        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        goToProfile();
        Thread.sleep(3000);
        removeBook();
        boolean bookRemoved = false;
        try {
            bookRemoved = driver.findElement(By.linkText("Git Pocket Guide")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(bookRemoved);

        removeBook();

        boolean book2Removed = false;
        try {
            book2Removed = driver.findElement(By.linkText("Learning JavaScript Design Patterns")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(book2Removed);

        js.executeScript("window.scrollBy(0,350)", "");
        WebElement goToStoreButton = driver.findElement(By.id("gotoStore"));
        goToStoreButton.click();

        addBook1();
        addBook2();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,350)", "");
        addBook3();

        js.executeScript("window.scrollBy(0,350)", "");
        goToProfile();

        Thread.sleep(2000);

        WebElement checkBook1 = driver.findElement(By.cssSelector(".rt-tr.-odd"));
        Assert.assertTrue(checkBook1.isDisplayed());

        WebElement checkBook2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(checkBook2.isDisplayed());

        WebElement checkBook3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(checkBook3.isDisplayed());

    }

    @Test (priority = 40)
    public void removePreviousAndAddFourBooks() throws InterruptedException {
        logIn();
        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        goToProfile();
        Thread.sleep(3000);

        removeBook();
        boolean bookRemoved = false;
        try {
            bookRemoved = driver.findElement(By.linkText("Git Pocket Guide")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(bookRemoved);

        removeBook();

        boolean book2Removed = false;
        try {
            book2Removed = driver.findElement(By.linkText("Learning JavaScript Design Patterns")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(book2Removed);

        removeBook();

        boolean book3Removed = false;
        try {
            book3Removed = driver.findElement(By.linkText("Learning JavaScript Design Patterns")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(book3Removed);


        js.executeScript("window.scrollBy(0,350)", "");
        WebElement goToStoreButton = driver.findElement(By.id("gotoStore"));
        goToStoreButton.click();

        addBook1();
        addBook2();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,350)", "");
        addBook3();
        js.executeScript("window.scrollBy(0,350)", "");
        addBook4();

        js.executeScript("window.scrollBy(0,350)", "");
        goToProfile();

        Thread.sleep(2000);

        WebElement checkBook1 = driver.findElement(By.cssSelector(".rt-tr.-odd"));
        Assert.assertTrue(checkBook1.isDisplayed());

        WebElement checkBook2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(checkBook2.isDisplayed());

        WebElement checkBook3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(checkBook3.isDisplayed());

        WebElement checkBook4 = driver.findElement(By.linkText("Speaking JavaScript"));
        Assert.assertTrue(checkBook4.isDisplayed());

    }




    public void removeBook() throws InterruptedException {
        WebElement removeBook1 = driver.findElement(By.id("delete-record-undefined"));
        removeBook1.click();

        WebElement removeBookPopUp = driver.findElement(By.id("closeSmallModal-ok"));
        removeBookPopUp.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(3000);

    }


    public void goToProfile() throws InterruptedException {

        Thread.sleep(3000);

        List<WebElement> buttons = driver.findElements(By.id("item-3"));

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Profile")) {
                buttons.get(i).click();
                break;
            }
        }

    }

    @AfterMethod
    public void afterEveryTest() {
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void afterThisClass() {
        //driver.quit();
    }


    }








