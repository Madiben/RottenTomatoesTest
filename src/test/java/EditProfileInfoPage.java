import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class EditProfileInfoPage extends PageBase {

    private By accountButton = By.xpath("/html/body/div[4]/header/nav/ul/li[4]/a");
    private By manageAccountbtn = By.xpath("//*[@id=\"main_container\"]/div[1]/section[1]/div/div[2]/a[1]");
    private By editprofilbtn = By.xpath("//*[@id=\"main-page-content\"]/section/div/div/ul/li[1]/h4/a");

    private By firstNameInputBoxBy = By.xpath("//div[@class='form-group']/div/input[@name='register_first_name']");
    private By lastNameInputBoxBy = By.xpath("//div[@class='form-group']/div/input[@name='register_last_name']");
    private By genderSelectBoxBy = By.xpath("//div[@class='form-group']/div/select[@name='register_gender']");
    private By countrySelectBoxBy = By.xpath("//div[@class='form-group']/div/select[@name='register_country']");

    private By submitButtonBy = By.xpath("//div/button[@id='personal_info_submit']");
    private By backButtonBy = By.xpath("//div/a[@class='button submitBtn']");

    private final By updateFormSuccessMessageBy = By.xpath("//div/div[@class='alert alert-success']");

    public EditProfileInfoPage(WebDriver driver) {
        super(driver);
    }
    public void accountClick(){
        waitAndReturnElement(accountButton).click();
     }
     public void manageprofileClick(){
        waitAndReturnElement(manageAccountbtn).click();
     }
     public void editprofilClick(){
        waitAndReturnElement(editprofilbtn).click();
     }

    public int firstNameIsInitialized() {
        if(waitAndReturnElement(firstNameInputBoxBy).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
    public int lastNameIsInitialized() {
        if(waitAndReturnElement(lastNameInputBoxBy).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
    public int genderIsInitialized() {
        if(waitAndReturnElement(genderSelectBoxBy).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
    public int countryIsInitialized() {
        if(waitAndReturnElement(countrySelectBoxBy).isDisplayed())
        {
            return 1;
        }else{
             return 0;
        }
    }
    public boolean submitbuttonIsInitialized() {
        return waitAndReturnElement(submitButtonBy).isDisplayed();
    }
    public void submitClick(){
        driver.findElement(submitButtonBy).click();
    }

    public boolean updateFormSuccessMessageIsInitialized() {
        return waitAndReturnElement(updateFormSuccessMessageBy).isDisplayed();
    }

    public String updateFormSuccessMessageGetText() {
        return waitAndReturnElement(updateFormSuccessMessageBy).getText();
    }
    public boolean backbuttonIsInitialized() {
        return waitAndReturnElement(backButtonBy).isDisplayed();
    }
    public void backClick(){
        driver.findElement(backButtonBy).click();
    }
    public void fillForm(String firstname, String lastName, String gender, String country) {
        waitAndReturnElement(firstNameInputBoxBy).clear();
        waitAndReturnElement(firstNameInputBoxBy).sendKeys(firstname);

        waitAndReturnElement(lastNameInputBoxBy).clear();
        waitAndReturnElement(lastNameInputBoxBy).sendKeys(lastName);

        Select drpGender = new Select(waitAndReturnElement(genderSelectBoxBy));
        drpGender.selectByVisibleText(gender);

        //waitAndReturnElement(genderSelectBoxBy).clear();
        //waitAndReturnElement(genderSelectBoxBy).sendKeys(gender);
        Select drpCountry = new Select(waitAndReturnElement(countrySelectBoxBy));
        drpCountry.selectByVisibleText(country);

        //waitAndReturnElement(countrySelectBoxBy).clear();
        //waitAndReturnElement(countrySelectBoxBy).sendKeys(country);

    }

    
}