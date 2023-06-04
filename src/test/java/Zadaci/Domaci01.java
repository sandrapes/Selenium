package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Domaci01 {

    public static void main(String[] args) {

        //Otici na YouTube preko Google pretrage, kada pristupite YouTube-u, odabrati pesmu po vasem izboru

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        searchbox.sendKeys("youtube");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        searchbox.click();

        WebElement youtube = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));
        youtube.click();

        WebElement youtubeSearch = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        youtubeSearch.sendKeys("zuca zvoganj");

        WebElement youtubeGoButton = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/button"));
        youtubeGoButton.click();

        WebElement video = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"));
        video.click();


    }


}
