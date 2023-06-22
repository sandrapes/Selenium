package herkouapp_basic_auth_login_test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Happy_Flow {

    public static void main(String[] args) {

        //Otici na sajt Herkouapp(https://the-internet.herokuapp.com/) i napisati sto vise test case-eva za log-in fun
        //kciju (Basic Auth).

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        String username = "admin";
        String password = "admin";

        String url = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(url);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        Assert.assertEquals(text.getText(), "Congratulations! You must have the proper credentials.");

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }
}
