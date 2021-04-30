import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

public class MainTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        //System.setProperty("webdriver.chrome.driver","F:Master 1 - S2//Software QaT//week5//week8//RottenTomatoes1rc//resources//chromedriver_win32"); 
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("javascriptEnabled");
        chromeOption.addArguments("nativeEvents");
        chromeOption.addArguments("locationContextEnabled");
        chromeOption.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOption);
        driver.manage().window().maximize();
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}