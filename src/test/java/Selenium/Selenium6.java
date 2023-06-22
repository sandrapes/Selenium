package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        Cookie loginCookie = new Cookie("wordpress_logged_in", "dragoljubqa%7C1780684786%7CdIxEK1ropfnFROP41VS57DQKrf9EYdEgb1N4MGUtSni%7Ca037608ee077d06e08e16029d3884cf658d11c4a44c3011f6a789d9510c64682");
        driver.manage().addCookie(loginCookie);
        driver.navigate().refresh();


    }
}
