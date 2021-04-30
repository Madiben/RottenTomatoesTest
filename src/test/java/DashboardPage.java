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


class DashboardPage extends PageBase {

    private By mainCardBy = By.xpath("//section[@class='trending-bar']/div/ul/li[@class='trending-bar__header']");
    //private By mainFooterBy = By.xpath("//div[@class='footer__copyright']/ul/li/span[@class='footer__copyright-legal']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }    
    
    public String getMainCardTitle(){
        return this.waitAndReturnElement(mainCardBy).getText();
    }
}
