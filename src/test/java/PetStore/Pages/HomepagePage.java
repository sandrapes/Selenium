package PetStore.Pages;

import PetStore.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//*[@id=\"MainImageContent\"]/map/area[2]")
    public WebElement fishPicture;

    @FindBy (xpath = "//*[@id=\"MainImageContent\"]/map/area[3]")
    public WebElement dogPicture;

    @FindBy (xpath = "//*[@id=\"MainImageContent\"]/map/area[4]")
    public WebElement reptilePicture;

    @FindBy (xpath = "//*[@id=\"MainImageContent\"]/map/area[5]")
    public WebElement catPicture;

    @FindBy (xpath = "//*[@id=\"MainImageContent\"]/map/area[6]")
    public WebElement birdPicture;

    @FindBy (xpath = "//*[@id=\"MenuContent\"]/a[1]/img")
    public WebElement cart;


    //===========================================


    public void clickOnFishPicture() {
        fishPicture.click();
    }

    public void clickOnDogPicture() {
        dogPicture.click();
    }
    public void clickOnReptilePicture() {
        reptilePicture.click();
    }
    public void clickOnCatPicture() {
        catPicture.click();
    }
    public void clickOnBirdPicture() {
        birdPicture.click();
    }

    public void clickOnCartButton() {
        cart.click();
    }

}
