package herkouapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarPage {

    public WebDriver driver;

    WebElement BasicAuthPage;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBasicAuthPage() {
         return driver.findElement(By.linkText("Basic Auth"));
    }


}
