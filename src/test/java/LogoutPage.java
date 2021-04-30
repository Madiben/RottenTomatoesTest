import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

class LogoutPage extends PageBase {

    private final By logoutButton = By.xpath("//*[@id=\"navbar\"]/ul/li[4]/ul/li[4]/a");
    private final By logouthover = By.xpath("/html/body/div[4]/header/nav/ul/li[4]/a");
    private final By maindash = By.xpath("//*[@id=\"navbar_brand\"]/a");


    public LogoutPage(WebDriver driver) {
        super(driver);
    }    
    public void LogoutClick(){
       String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
            ((JavascriptExecutor)driver).executeScript(javaScript, waitAndReturnElement(logouthover));
            waitAndReturnElement(logoutButton).click();
        }
    public void mainDash(){
        waitAndReturnElement(maindash).click();
    }
}
    
