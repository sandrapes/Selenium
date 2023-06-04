package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

public class LinkedIn_Joberty {

    public static void main(String[] args) {

        ////Zadatak 1
        ////Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
        ////vratite se nazad i odstampajte poslednji URL na kom se nalazite
        ////na kraju zatvorite driver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.linkedin.com/");
        driver.navigate().refresh();
        driver.navigate().to("https://www.joberty.rs/");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.quit();

    }
}
