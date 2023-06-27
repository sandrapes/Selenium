package PetStore.Tests;


import PetStore.Base.BaseTest;
import PetStore.Pages.BulldogsPage;
import PetStore.Pages.DogsPage;
import PetStore.Pages.HomepagePage;
import PetStore.Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    public HomepagePage homepagePage;
    public DogsPage dogsPage;
    public BulldogsPage bulldogsPage;
    public ShoppingCartPage shoppingCartPage;


    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        homepagePage = new HomepagePage();
        dogsPage = new DogsPage();
        bulldogsPage = new BulldogsPage();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test
    public void UserCanAddOneItemToCart() {
        homepagePage.clickOnDogPicture();
        dogsPage.clickOnBulldog();
        bulldogsPage.addMaleBulldogToCart();

        Assert.assertEquals(shoppingCartPage.addedItem.getText(), "Male Adult Bulldog");
        Assert.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-6");

    }

    @Test
    public void UserCanAddDifferentItemToCart() {
        homepagePage.clickOnDogPicture();
        dogsPage.clickOnBulldog();
        bulldogsPage.addFemalePuppyToCart();

    }

    @Test
    public void UserCanGoToCartFromHomePage() {
        homepagePage.clickOnCartButton();

        Assert.assertEquals(shoppingCartPage.cartHeadline.getText(), "Shopping Cart");
        Assert.assertTrue(elementIsPresent(shoppingCartPage.updateCartButton));
    }

    @Test
    public void userCanRemoveAnItemFromCart() {


    }


}
