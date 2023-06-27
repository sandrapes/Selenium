package PetStore.Pages;

import PetStore.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BulldogsPage extends BaseTest {

    public BulldogsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]")
    public WebElement maleBulldogAddToCartButton;

    @FindBy (xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[5]/a")
    public WebElement femalePuppyAddToCartButton;

    //=====================================

    public void addMaleBulldogToCart() {
        maleBulldogAddToCartButton.click();

    }

    public void addFemalePuppyToCart() {
        femalePuppyAddToCartButton.click();
    }


}
