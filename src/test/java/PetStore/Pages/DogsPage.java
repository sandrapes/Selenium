package PetStore.Pages;

import PetStore.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DogsPage extends BaseTest {

    public DogsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "K9-BD-01")
    public WebElement bulldog;


    //========================================

    public void clickOnBulldog() {
        bulldog.click();
    }




}
