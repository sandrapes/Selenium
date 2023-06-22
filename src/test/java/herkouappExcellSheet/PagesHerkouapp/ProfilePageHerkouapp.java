package herkouappExcellSheet.PagesHerkouapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageHerkouapp {

    public WebDriver driver;

    WebElement confirmation;

    public ProfilePageHerkouapp(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getConfirmation() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
    }
}
