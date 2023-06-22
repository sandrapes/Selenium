package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/");

        Cookie logInCookie = new Cookie("wordpress_logged_in", "sandrapes%7C1780685284%7Cr7OD9lHfyiWzFZ2SlhmG8dJyI6K0cz42b5LmfS1D0Xr%7Cf5314e25e7aeb627c07f4084d3e1b237857284d3f6165573d10b7e7127a188e4");
        driver.manage().addCookie(logInCookie);
        driver.navigate().refresh();







    }
}
