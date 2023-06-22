package herkouappExcellSheet.PagesHerkouapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarPageHerkouapp {

    public WebDriver driver;

    WebElement BasicAuthPage;

    public SidebarPageHerkouapp(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBasicAuthPage() {
        return driver.findElement(By.linkText("Basic Auth"));
    }


}
