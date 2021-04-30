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
import com.github.javafaker.Faker;

public class LoginPageTest extends MainTest{
    @Test
    public void atestlogin() {
        MainPage mainPage = new MainPage(this.driver);
        StaticMainPage staticMainPage = new StaticMainPage(driver);
        System.out.println(staticMainPage.getpopularMovieTitle());
        Assert.assertTrue(staticMainPage.getpopularMovieTitle().contains("POPULAR STREAMING MOVIES"));
        System.out.println(staticMainPage.getpopularTVTitle());
        Assert.assertTrue(staticMainPage.getpopularTVTitle().contains("MOST POPULAR TV ON RT"));
        System.out.println(staticMainPage.getnewTVTitle());
        Assert.assertTrue(staticMainPage.getnewTVTitle().contains("NEW TV THIS WEEK"));

        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        //Login
        LoginPage loginPage = mainPage.openLogin();
        DashboardPage dashboardPage = loginPage.login("lerafiw926@hype68.com","123456aa");
        
        System.out.println(dashboardPage.getMainCardTitle());
        Assert.assertTrue(dashboardPage.getMainCardTitle().contains("TRENDING ON RT"));

        ///test edit profile
        EditProfileInfoPage editProfileInfoPage = new EditProfileInfoPage(driver);
        editProfileInfoPage.accountClick();

        editProfileInfoPage.manageprofileClick();

        editProfileInfoPage.editprofilClick();

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = faker.options().option("Male", "Female");
        String country =  faker.options().option("Hungary", "Algeria", "Poland", "France", "Spain","Greece","Japan","Kenya","Italy","Germany");
      //  String country =  faker.aderess().country();
        WebDriverWait wait = new WebDriverWait(driver, 25);



        Assert.assertEquals(editProfileInfoPage.firstNameIsInitialized(),1);
        Assert.assertEquals(editProfileInfoPage.lastNameIsInitialized(),1);
        Assert.assertEquals(editProfileInfoPage.genderIsInitialized(),1);
        Assert.assertEquals(editProfileInfoPage.countryIsInitialized(),1);

        editProfileInfoPage.fillForm(firstName, lastName, gender, country);

        Assert.assertTrue(editProfileInfoPage.submitbuttonIsInitialized());
        editProfileInfoPage.submitClick();

        Assert.assertTrue(editProfileInfoPage.updateFormSuccessMessageIsInitialized());
        System.out.println(editProfileInfoPage.updateFormSuccessMessageGetText());
        Assert.assertTrue(editProfileInfoPage.updateFormSuccessMessageGetText().contains("Your personal information has been successfully updated."));
 
        Assert.assertTrue(editProfileInfoPage.backbuttonIsInitialized());
        editProfileInfoPage.backClick();


        /// test review movie    
        
        String review = faker.lorem().sentence(6);

        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        ReviewMovie reviewMovie = new ReviewMovie(driver);
        
        reviewMovie.topBoxOfficeClick();

        reviewMovie.openMovieClick();

        System.out.println(reviewMovie.getMovieTitle());
        Assert.assertTrue(reviewMovie.getMovieTitle().contains("MARIGHELLA"));

        reviewMovie.movieRateClick();

        Assert.assertEquals(reviewMovie.movieReviewCardInitialized(),1);
        
        reviewMovie.movieReview(review);
        Assert.assertTrue(reviewMovie.submitbuttonIsInitialized());
        reviewMovie.submitReviewClick();

        System.out.println(reviewMovie.getThanksReviewMessage());
        Assert.assertTrue(reviewMovie.getThanksReviewMessage().contains("Thank you for your review"));

        reviewMovie.closeThanksWindowClick();

        Assert.assertEquals(reviewMovie.checkMyReviewInitialized(),1);
        
        System.out.println(reviewMovie.checkMyReview());
        Assert.assertTrue(reviewMovie.checkMyReview().contains(review));

        ///test logout
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.mainDash();
        logoutPage.LogoutClick();
    }

}
