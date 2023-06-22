package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Knjizara_Kolacici_Drag {
    public static void main(String[] args) throws InterruptedException {

        //Ulogovati se na sajt https://demoqa.com/ preko kolacica, dodati knjige
        //obrisati sve knjige

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/profile");

        //Pred sam log in sam obrisao sve kolacice da bih dobio realnu sliku koji su potrebni za logovanje
        //Nasao sam 4 kolacica i resio sam da ih sve dodam

        Cookie cookie1 = new Cookie("userID", "362c8c84-7846-4bcd-9625-ef0df047ff54");
        Cookie cookie2 = new Cookie("userName", "dragoljubqa");
        Cookie cookie3 = new Cookie("expires", "2023-10-15T17%3A02%3A58.452Z");
        Cookie cookie4 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2ODYyNDY4NDF9.Vhpln50bfv1g39uAEwhjOI8PlziQy9EoO3Kqn38Q1rM");

        driver.manage().addCookie(cookie1);
        //driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);

        driver.navigate().refresh();

        //Nakon sto sam dodao svih cetiri krenuo sam u proveru da li su svi neophodni za logovanje
        //Video sam da drugi kolacic nije bitan za logovanje i preskocio sam njegovo dodavanje

        //Sada mi treba da kliknem na dugme "Delete All Books"

        /*WebElement deleteAllBooks = driver.findElement(By.id("submit"));
        deleteAllBooks.click();*/

        //Nasao sam id ali kada odradim tu akciju mene program zapravo izloguje
        //Onda sam se ponovo ulogovao da vidim da li brisanjem svih knjiga pokrece i log out funkciju
        //Video sam da su knjige jos na profilu sto znaci da sam kliknu pogresno dugme
        //Kada sam otvorio inspect element kopirao sam vrednost lokatora i ubacio u search (ctrl + F)
        //Sada vidim da postoje jos 4 id lokatora sa istom vrednoscu
        //Da bih dohvatio neki od tih elemenata moram sve da ih smestim u listu

        List<WebElement> buttons = driver.findElements(By.id("submit"));

        //Zelim da kliknem na treci element na sledeci nacin:
        //buttons.get(2).click();
        //Ali sta ako se u nekom trenutku elementi zamene?
        //Ili sta ako se neko dugme sa istim lokatorom doda ili oduzme?
        //Ponovo cu kliknuti na pogresan element
        //Zato mi treba nacin da se uverim da sam kliknuo na pravo dugme

        //Pozivam for petlju koja ce da prodje kroz svaki web element, da proveri zapis tog elementa
        //i odradice klik samo na onaj element koji se zove "Delete All Books"

        for (int i = 0; i < buttons.size(); i++) { //Prolazim kroz celu listu
            if (buttons.get(i).getText().equals("Delete All Books")) { //Proveravam da li se tekst elementa podudara
                buttons.get(i).click(); //Ako se podudara onda zelim da odradim klik na taj element
                break; //Obavezno dodajem break da bi program prestao da trazi druge elemente nakon klika
            }
        }

        WebElement confirmButton = driver.findElement(By.id("closeSmallModal-ok"));
        confirmButton.click();

        driver.navigate().refresh();

    }
}

