import javax.management.loading.PrivateClassLoader;

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
class ReviewMovie extends PageBase {

    private By MenuMoviesHover = By.xpath("//*[@id=\"masthead-dropdown-menus\"]/ul/li[1]");
    private By boxOfficeButton = By.xpath("//*[@id=\"masthead-dropdown-menus\"]/ul/li[1]/div/section[1]/ul/li[2]/a");
    private By openMovieButton = By.xpath("//*[@id=\"content-column\"]/div[2]/div[2]/div[3]/div[1]/a");
    private By movieTitle = By.xpath("//*[@id=\"topSection\"]/score-board/h1");
    private By movieRating = By.xpath("//*[@id=\"rating-widget-desktop\"]/div/section/div[2]/div[1]/div[1]/span/span[5]/span[2]");
    private By movieReviewTextView = By.xpath("//*[@id=\"rating-root\"]/aside[1]/div/div/div[2]/div/div/textarea");
    private By submitReviewButton = By.xpath("//*[@id=\"rating-root\"]/aside[1]/div/div/div[3]/button");
    private By submitEditReviewButton = By.xpath("/html/body/div[5]/div[3]/section/div[2]/div[2]/div[4]/div/div[2]/aside[1]/div[2]/button");
    private By thanksForReviewTxt = By.xpath("//*[@id=\"rating-root\"]/aside[4]/div[2]/div/div/h3");
    private By closeThanksWindowButton = By.xpath("//*[@id=\"rating-root\"]/aside[4]/div[2]/button");
    private By checkMyReview = By.xpath("//*[@id=\"rating-widget-desktop\"]/div/section/div[2]/div[2]/div/div/p");
    private By editReviewButton = By.xpath("//*[@id=\"rating-widget-desktop\"]/div/section/div[2]/div[1]/button[1]");

    public ReviewMovie(WebDriver driver) {
        super(driver);
    }
    public void topBoxOfficeClick(){
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                     "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                     "arguments[0].dispatchEvent(evObj);";
 
 
        ((JavascriptExecutor)driver).executeScript(javaScript, waitAndReturnElement(MenuMoviesHover)); 
        waitAndReturnElement(boxOfficeButton).click();
     }
     public void openMovieClick(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('target', '_self');",waitAndReturnElement(openMovieButton));
        waitAndReturnElement(openMovieButton).click();
     }

     public String getMovieTitle(){
        return this.waitAndReturnElement(movieTitle).getText();
    }
    public void movieRateClick(){
        try{
            waitAndReturnElement(movieRating).click();
        }catch (Exception e) {
            editReview();
          }
     }
    public void editReview(){
        waitAndReturnElement(editReviewButton).click();
    }
     public int movieReviewCardInitialized() {
        if(waitAndReturnElement(movieReviewTextView).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
    public void movieReview(String review)
    {
        waitAndReturnElement(movieReviewTextView).clear();
        waitAndReturnElement(movieReviewTextView).sendKeys(review);
    }
    public boolean submitbuttonIsInitialized() {
        try{
            return waitAndReturnElement(submitReviewButton).isDisplayed();
        }catch (Exception e) {
            return waitAndReturnElement(submitEditReviewButton).isDisplayed();
        }
    }
    public void submitReviewClick(){
        try{
        waitAndReturnElement(submitReviewButton).click();
        }catch (Exception e) {
        waitAndReturnElement(submitEditReviewButton).click();
      }
     }
     public String getThanksReviewMessage(){
        return this.waitAndReturnElement(thanksForReviewTxt).getText();
    }
    public void closeThanksWindowClick(){
        waitAndReturnElement(closeThanksWindowButton).click();
     }
     public int checkMyReviewInitialized() {
        if(waitAndReturnElement(checkMyReview).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
     public String checkMyReview(){
        return this.waitAndReturnElement(checkMyReview).getText();
    }

    
}