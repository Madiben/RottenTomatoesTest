import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class StaticMainPage extends PageBase {

    private By popularMovieTitle = By.xpath("/html/body/div[4]/main/div[1]/section/section[3]/div[2]/div/div[2]/div[1]/section/text-list/h2");
    private By popularTVTitle = By.xpath("/html/body/div[4]/main/div[1]/section/section[3]/div[2]/div/div[2]/div[2]/section/text-list/h2");
    private By newTVTitle = By.xpath("/html/body/div[4]/main/div[1]/section/section[3]/div[2]/div/div[2]/div[3]/section/text-list/h2");
    //private By mainFooterBy = By.xpath("//div[@class='footer__copyright']/ul/li/span[@class='footer__copyright-legal']");

    public StaticMainPage(WebDriver driver) {
        super(driver);
    }    
    
    public String getpopularMovieTitle(){
        return this.waitAndReturnElement(popularMovieTitle).getText();
    }
    public String getpopularTVTitle(){
        return this.waitAndReturnElement(popularTVTitle).getText();
    }
    public String getnewTVTitle(){
        return this.waitAndReturnElement(newTVTitle).getText();
    }
}
