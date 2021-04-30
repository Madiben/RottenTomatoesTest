import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

class LogoutPage extends PageBase {

    private final By logoutButton = By.xpath("//header[@class='masthead']/nav/ul/li/ul/li/a[@class='masthead-account__dropdown--link js-masthead-account-logout-btn']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }    
    public void LogoutClick(){
        driver.findElement(logoutButton).click();
    }
    
}
