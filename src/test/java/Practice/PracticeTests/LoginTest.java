package Practice.PracticeTests;

import Practice.PracticeBase.PracticeBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends PracticeBaseTest {
    //12. Test klasa treba da ekstenduje BaseTest klasu
    //13. Krairamo metodu pageSetUp koja ima anotaciju BeforeMethod
    //sto znaci da ce se ova metoda izvrsiti pre svakog testa
    //Obratiti paznju da se ova metoda ne zove isto kao metoda za anotaciju BeforeClass
    //u tom slucaju ova metoda ce da pregazi prethodnu
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    //14. Krairam testove tako sto naziv metode dajem kako bih nazvao i manuelno napisan test case
    @Test
    public void userCanLogIn() {
        //15. Nazivi metoda akcija treba da nose nazive kao da pisemo korake u test case-u
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("student");
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("username");
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
    }
}
