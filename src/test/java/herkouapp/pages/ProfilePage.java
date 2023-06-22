package herkouapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    public WebDriver driver;

    WebElement confirmation;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getConfirmation() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
    }


}
