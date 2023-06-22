package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Domaci_kolaci_knjizara {

    public static void main(String[] args) throws InterruptedException {

        //Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a, dodati dve knjig
        //e na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");

        Cookie cookie1 = new Cookie("userID", "aed3cc5f-1483-449b-858e-8e761b4211ca");
        Cookie cookie2 = new Cookie("userName", "sandrapes");
        Cookie cookie4 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InNhbmRyYXBlcyIsInBhc3N3b3JkIjoiTmVraXJlbmRvbXBhc3MxMjU2ISIsImlhdCI6MTY4NjEzNTgxMX0.LgeROqD4cbmquGLZqET0nQybTt94JD4UXk90E6o0QvY");
        Cookie cookie3 = new Cookie("expires", "2023-06-14T11%3A03%3A31.146Z");

        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        driver.manage().window().fullscreen();

        Thread.sleep(3000);
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();
        driver.manage().window().maximize();

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();
        driver.manage().window().fullscreen();

        Thread.sleep(3000);
        WebElement addBook2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook2.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().back();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        loginButton.click();

        String username = "sandrapes";
        String password = "Nekirendompass1256!";
        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        Thread.sleep(3000);
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        Thread.sleep(3000);
        WebElement profileBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
        profileBtn.click();

        Thread.sleep(3000);
        WebElement checkbook1 = driver.findElement(By.cssSelector(".rt-tr.-odd"));
        Assert.assertTrue(checkbook1.isDisplayed());

        Thread.sleep(3000);
        WebElement checkBook2 = driver.findElement(By.cssSelector(".rt-tr.-even"));
        Assert.assertTrue(checkBook2.isDisplayed());







    }
}
