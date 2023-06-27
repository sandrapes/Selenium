package PetStore.Pages;

import PetStore.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseTest {

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "Proceed to Checkout")
    public WebElement proceedToCheckoutButton;

    @FindBy (xpath = "//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[3]")
    public WebElement addedItem;

    @FindBy (xpath = "//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input")
    public WebElement quantity;

    @FindBy (xpath = "//*[@id=\"Cart\"]/h2")
    public WebElement cartHeadline;

    @FindBy (xpath = "//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input")
    public WebElement updateCartButton;

    @FindBy (linkText = "Remove")
    public WebElement removeButton;

    public void clickOnProceedToCheckoutbtton() {
        proceedToCheckoutButton.click();
    }

    public void changeQuantityOfItem(int number) {
        quantity.clear();
        quantity.sendKeys(String.valueOf(number)); //ako hocemo da prosledimo int a ne string
    }

    public void clickOnRemoveButton() {
        removeButton.click();
    }

}
